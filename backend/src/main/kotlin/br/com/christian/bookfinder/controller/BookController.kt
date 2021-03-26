package br.com.christian.bookfinder.controller

import br.com.christian.bookfinder.model.Book
import br.com.christian.bookfinder.repository.BookRepository
import br.com.christian.bookfinder.service.BookServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")
class BookController {
    @Autowired
    lateinit var bookService: BookServiceImpl

    @GetMapping("/{id}")
    fun getBook(@PathVariable id: Long): Book {
        return bookService.findById(id)
    }

    @PostMapping
    fun addBook(@RequestBody book: Book): Book {
        bookService.save(book)
        return book
    }
}
