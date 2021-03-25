package br.com.christian.bookfinder.controller

import br.com.christian.bookfinder.model.Store
import br.com.christian.bookfinder.repository.StoreRepository
import br.com.christian.bookfinder.service.StoreServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
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

    @PostMapping
    fun addStore(@RequestBody store: Store): Store {
        storeService.save(store)
        return store
    }
}
