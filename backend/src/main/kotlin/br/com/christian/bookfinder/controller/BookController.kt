package br.com.christian.bookfinder.controller

import br.com.christian.bookfinder.model.Book
import br.com.christian.bookfinder.repository.BookRepository
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
    lateinit var bookRepository: BookRepository

    @GetMapping("/{id}")
    fun findBook(@PathVariable id: Long): Book {
        return bookRepository.findById(id).get()
    }

    @PostMapping
    fun addBook(@RequestBody book: Book): Book {
        return bookRepository.save(book)
    }
}
