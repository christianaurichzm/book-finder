package br.com.christian.bookfinder.service

import br.com.christian.bookfinder.model.Store

interface StoreService {
    fun findAll(): List<Store>

    fun findById(id: Long): Store

    fun save(store: Store)

    fun deleteById(id: Long)
}
