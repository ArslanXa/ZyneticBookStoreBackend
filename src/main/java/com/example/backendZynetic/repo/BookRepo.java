package com.example.backendZynetic.repo;

import com.example.backendZynetic.model.Book;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {


    @Query("SELECT b FROM Book b WHERE lower(b.title) LIKE lower(concat('%', :title, '%'))")
    List<Book> searchByTitle(@Param("title") String title);


    @Query("SELECT b FROM Book b WHERE " +
            "(:author IS NULL OR lower(b.author) = lower(:author)) AND " +
            "(:category IS NULL OR lower(b.category) = lower(:category)) AND " +
            "(:rating IS NULL OR b.rating >= :rating)")
    List<Book> filterBooks(
            @Param("author") String author,
            @Param("category") String category,
            @Param("rating") Double rating
    );
}
