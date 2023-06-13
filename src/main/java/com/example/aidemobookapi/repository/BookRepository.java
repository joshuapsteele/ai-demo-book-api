package com.example.aidemobookapi.repository;

import com.example.aidemobookapi.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // You get CRUD methods for free from JpaRepository
}
