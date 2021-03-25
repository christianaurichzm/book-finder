package br.com.christian.bookfinder.service

import br.com.christian.bookfinder.model.Book
import br.com.christian.bookfinder.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookServiceImpl : BookService {
    @Autowired
    lateinit var bookRepository: BookRepository

    override fun findAll(): List<Book> {
        return bookRepository.findAll()
    }

    override fun findById(id: Long): Book {
        return bookRepository.findById(id).get()
    }

    override fun save(book: Book) {
        bookRepository.save(book)
    }

    override fun deleteById(id: Long) {
        bookRepository.deleteById(id)
    }
}
