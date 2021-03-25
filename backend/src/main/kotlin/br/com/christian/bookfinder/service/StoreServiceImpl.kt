package br.com.christian.bookfinder.service

import br.com.christian.bookfinder.model.Store
import br.com.christian.bookfinder.repository.StoreRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StoreServiceImpl : StoreService {
    @Autowired
    lateinit var storeRepository: StoreRepository

    override fun findAll(): List<Store> {
        return storeRepository.findAll()
    }

    override fun findById(id: Long): Store {
        return storeRepository.findById(id).get()
    }

    override fun save(store: Store) {
        storeRepository.save(store)
    }

    override fun deleteById(id: Long) {
        storeRepository.deleteById(id)
    }
}
