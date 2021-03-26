package br.com.christian.bookfinder.service

import br.com.christian.bookfinder.model.Copy

interface CopyService {
    fun findAll(): List<Copy>

    fun findById(id: Long): Copy

    fun save(copy: Copy)

    fun deleteById(id: Long)
}