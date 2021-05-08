package br.com.christian.bookfinder.repository

import br.com.christian.bookfinder.model.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book, Long> {
    fun findByTitleIgnoreCaseContaining(title: String): Book
}
