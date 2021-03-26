package br.com.christian.bookfinder.service

import br.com.christian.bookfinder.model.Book
import br.com.christian.bookfinder.model.Store

interface BookService {
    fun findStoresByBookId(id: Long): List<Store>?

    fun findAll(): List<Book>

    fun findById(id: Long): Book

    fun save(book: Book): Book

    fun deleteById(id: Long)
}
