package br.com.christian.bookfinder.service

import br.com.christian.bookfinder.model.Book
import br.com.christian.bookfinder.model.Store
import br.com.christian.bookfinder.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BookServiceImpl : BookService {
    @Autowired
    lateinit var bookRepository: BookRepository

    override fun findStoresByBook(book: Book): List<Store>? {
        return book.copies?.map { it.store }?.distinctBy { it.id }
    }

    @Transactional
    override fun findStoresByBookId(id: Long): List<Store>? {
        val bookToFind = findById(id)
        return findStoresByBook(bookToFind)
    }

    @Transactional
    override fun findStoresByBookTitle(title: String): List<Store>? {
        val bookToFind = findByTitle(title)
        return findStoresByBook(bookToFind)
    }

    @Transactional
    override fun findAll(): List<Book> {
        return bookRepository.findAll()
    }

    @Transactional
    override fun findById(id: Long): Book {
        return bookRepository.findById(id).get()
    }

    @Transactional
    override fun findByTitle(title: String): Book {
        return bookRepository.findByTitleIgnoreCaseContaining(title)
    }

    @Transactional
    override fun save(book: Book): Book {
        return bookRepository.save(book)
    }

    @Transactional
    override fun deleteById(id: Long) {
        bookRepository.deleteById(id)
    }
}
