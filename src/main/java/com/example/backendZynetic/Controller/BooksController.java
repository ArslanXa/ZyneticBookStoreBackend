package com.example.backendZynetic.Controller;


import com.example.backendZynetic.DTO.BookDto;
import com.example.backendZynetic.DTO.PagedResponse;
import com.example.backendZynetic.model.Book;
import com.example.backendZynetic.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BooksController {

    private final BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<BookDto> createBook(@Valid @RequestBody BookDto bookDto) {
        BookDto book = bookService.createBook(bookDto);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @GetMapping("/getallbooks")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        List<BookDto> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/getallbookspaged")
    public ResponseEntity<PagedResponse<BookDto>> getPagedBooks(Pageable pageable) {
        Page<BookDto> booksPage = bookService.getAllBooks(pageable);

        PagedResponse<BookDto> response = new PagedResponse<>(
                booksPage.getContent(),
                booksPage.getNumber(),
                booksPage.getSize(),
                booksPage.getTotalElements(),
                booksPage.getTotalPages(),
                booksPage.isLast()
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Integer id) {
        BookDto book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDto> updateBook(
            @PathVariable Integer id,
           @Valid @RequestBody BookDto bookDto) {
        BookDto updatedBook = bookService.updateBook(id, bookDto);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }



    @GetMapping("/filter")
    public ResponseEntity<List<Book>> filterBooks(
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double rating
    ) {
        List<Book> books = bookService.filterBooks(author, category, rating);
        return ResponseEntity.ok(books);
    }


    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam String title) {
        List<Book> books = bookService.searchBooksByTitle(title);
        return ResponseEntity.ok(books);
    }
    @GetMapping("/sort")
    public ResponseEntity<List<BookDto>> sortBooks(
            @RequestParam(defaultValue = "price") String basedOn,
            @RequestParam(defaultValue = "true") Boolean ascending
    ) {
        List<BookDto> books = bookService.sortBooks(basedOn, ascending);
        return ResponseEntity.ok(books);
    }


}