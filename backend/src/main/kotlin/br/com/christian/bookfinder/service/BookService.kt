package br.com.christian.bookfinder.service

import br.com.christian.bookfinder.model.Book
import br.com.christian.bookfinder.model.Store

interface BookService {
    fun findStoresByBook(book: Book): List<Store>?

    fun findStoresByBookId(id: Long): List<Store>?

    fun findStoresByBookTitle(title: String): List<Store>?

    fun findAll(): List<Book>

    fun findById(id: Long): Book

    fun findByTitle(title: String): Book

    fun save(book: Book): Book

    fun deleteById(id: Long)
}
