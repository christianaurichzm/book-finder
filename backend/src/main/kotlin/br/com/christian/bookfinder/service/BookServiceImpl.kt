package br.com.christian.bookfinder.service

import br.com.christian.bookfinder.model.Book
import br.com.christian.bookfinder.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BookServiceImpl : BookService {
    @Autowired
    lateinit var bookRepository: BookRepository

    @Transactional
    override fun findAll(): List<Book> {
        return bookRepository.findAll()
    }

    @Transactional
    override fun findById(id: Long): Book {
        return bookRepository.findById(id).get()
    }

    @Transactional
    override fun save(book: Book) {
        bookRepository.save(book)
    }

    @Transactional
    override fun deleteById(id: Long) {
        bookRepository.deleteById(id)
    }
}
