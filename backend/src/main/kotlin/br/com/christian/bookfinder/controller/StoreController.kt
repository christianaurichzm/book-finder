package br.com.christian.bookfinder.controller

import br.com.christian.bookfinder.model.Book
import br.com.christian.bookfinder.model.Store
import br.com.christian.bookfinder.repository.StoreRepository
import br.com.christian.bookfinder.service.StoreServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/stores")
class StoreController {
    @Autowired
    lateinit var storeService: StoreServiceImpl

    @GetMapping("/{id}")
    fun getStore(@PathVariable id: Long): Store {
        return storeService.findById(id)
    }

    @GetMapping
    fun getAllStores(): List<Store> {
        return storeService.findAll()
    }

    @PostMapping
    fun addStore(@RequestBody store: Store): Store {
        return storeService.save(store)
    }

    @PutMapping("/{id}")
    fun updateStore(@PathVariable id: Long, @RequestBody store: Store): Store {
        storeService.findById(id).let {
            it.name = store.name
            return storeService.save(it)
        }
    }

    @DeleteMapping("/{id}")
    fun removeStore(@PathVariable id: Long) {
        storeService.deleteById(id)
    }
}
