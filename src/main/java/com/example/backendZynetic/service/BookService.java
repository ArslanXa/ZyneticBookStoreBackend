package com.example.backendZynetic.service;

import com.example.backendZynetic.DTO.BookDto;
import com.example.backendZynetic.model.Book;
import com.example.backendZynetic.repo.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepo bookRepository;
    public BookDto createBook(BookDto bookDto) {
        Book savedBook = bookRepository.save(bookDto.toBook());
        return savedBook.toBookDto();
    }

    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(Book::toBookDto)
                .collect(Collectors.toList());
    }

    public Page<BookDto> getAllBooks(Pageable pageable) {
        return bookRepository.findAll(pageable)
                .map(Book::toBookDto);
    }

    public BookDto getBookById(Integer id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with id: " + id));
        return book.toBookDto();
    }

    public BookDto updateBook(Integer id, BookDto bookDto) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with id: " + id));

        existingBook.setTitle(bookDto.getTitle());
        existingBook.setAuthor(bookDto.getAuthor());
        existingBook.setCategory(bookDto.getCategory());
        existingBook.setPrice(bookDto.getPrice());
        existingBook.setRating(bookDto.getRating());
        existingBook.setPublishedDate(bookDto.getPublishedDate());

        Book updatedBook = bookRepository.save(existingBook);
        return updatedBook.toBookDto();
    }

    public void deleteBook(Integer id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with id: " + id));
        bookRepository.delete(book);
    }

    public List<Book> filterBooks(String author, String category, Double rating) {
        return bookRepository.filterBooks(author, category, rating);
    }

    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.searchByTitle(title);
    }
    public List<BookDto> sortBooks(String basedOn, Boolean ascending) {
        Sort.Direction direction = ascending ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, basedOn);

        List<Book> books = bookRepository.findAll(sort);

        return books.stream()
                .map(Book::toBookDto)
                .collect(Collectors.toList());
    }


}

