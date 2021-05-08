package br.com.christian.bookfinder.service

import br.com.christian.bookfinder.model.Book
import br.com.christian.bookfinder.repository.BookRepository
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.Bean
import org.springframework.test.context.junit4.SpringRunner
import org.mockito.Mockito
import java.util.Optional

@RunWith(SpringRunner::class)
class BookServiceTest {
    @TestConfiguration
    internal class BookTestContextConfiguration {
        @Bean
        fun bookService(): BookService {
            return BookServiceImpl()
        }
    }

    @Autowired
    lateinit var bookService: BookService

    @MockBean
    lateinit var bookRepository: BookRepository

    @Before
    fun setUp() {
        val book = Book(2, "Book", listOf())
        Mockito.`when`(bookRepository.findById(book.id))
            .thenReturn(Optional.of(book))
    }

    @Test
    fun findByIdTest() {
        val id = 2L
        val book = bookService.findById(id)
        assertEquals(id, book.id)
        assertEquals("Book", book.title)
    }
}