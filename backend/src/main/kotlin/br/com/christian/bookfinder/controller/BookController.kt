package br.com.christian.bookfinder.controller

import br.com.christian.bookfinder.model.Book
import br.com.christian.bookfinder.model.Store
import br.com.christian.bookfinder.service.BookServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")
class BookController {
    @Autowired
    lateinit var bookService: BookServiceImpl

    @RequestMapping("/find/{id}")
    fun findBookStores(@PathVariable id: Long): List<Store>? {
        return bookService.findStoresByBookId(id)
    }

    @GetMapping("/{id}")
    fun getBook(@PathVariable id: Long): Book {
        return bookService.findById(id)
    }

    @GetMapping
    fun getAllBooks(): List<Book> {
        return bookService.findAll()
    }

    @PostMapping
    fun addBook(@RequestBody book: Book): Book {
        return bookService.save(book)
    }

    @PutMapping("/{id}")
    fun updateBook(@PathVariable id: Long, @RequestBody book: Book): Book {
        bookService.findById(id).let {
            it.title = book.title
            return bookService.save(it)
        }
    }

    @DeleteMapping("/{id}")
    fun removeBook(@PathVariable id: Long) {
        bookService.deleteById(id)
    }
}
