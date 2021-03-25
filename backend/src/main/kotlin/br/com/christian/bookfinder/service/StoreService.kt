package br.com.christian.bookfinder.service

import br.com.christian.bookfinder.model.Book

interface BookService {
    fun findAll(): List<Book>

    fun findById(id: Long): Book

    fun save(book: Book)

    fun deleteById(id: Long)
}
