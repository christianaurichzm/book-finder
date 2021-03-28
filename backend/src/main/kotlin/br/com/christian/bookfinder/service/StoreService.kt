package br.com.christian.bookfinder.service

import br.com.christian.bookfinder.model.Copy
import br.com.christian.bookfinder.model.Store

interface StoreService {
    fun getStock(id: Long): List<Copy>?

    fun findAll(): List<Store>

    fun findById(id: Long): Store

    fun save(store: Store): Store

    fun deleteById(id: Long)
}
