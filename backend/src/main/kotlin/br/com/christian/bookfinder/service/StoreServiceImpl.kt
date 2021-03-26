package br.com.christian.bookfinder.service

import br.com.christian.bookfinder.model.Copy
import br.com.christian.bookfinder.model.Store
import br.com.christian.bookfinder.repository.StoreRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class StoreServiceImpl : StoreService {
    @Autowired
    lateinit var storeRepository: StoreRepository

    @Transactional
    override fun getStock(id: Long): List<Copy> {
        return findById(id).copies.distinctBy { it.book.id }
    }

    @Transactional
    override fun findAll(): List<Store> {
        return storeRepository.findAll()
    }

    @Transactional
    override fun findById(id: Long): Store {
        return storeRepository.findById(id).get()
    }

    @Transactional
    override fun save(store: Store): Store {
        return storeRepository.save(store)
    }

    @Transactional
    override fun deleteById(id: Long) {
        storeRepository.deleteById(id)
    }
}
