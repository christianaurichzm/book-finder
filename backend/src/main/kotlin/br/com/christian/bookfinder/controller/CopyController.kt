package br.com.christian.bookfinder.controller

import br.com.christian.bookfinder.model.Copy
import br.com.christian.bookfinder.service.CopyServiceImpl
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
@RequestMapping("/copies")
class CopyController {
    @Autowired
    lateinit var copyService: CopyServiceImpl

    @GetMapping("/{id}")
    fun getCopy(@PathVariable id: Long): Copy {
        return copyService.findById(id)
    }

    @GetMapping
    fun getAllCopies(): List<Copy> {
        return copyService.findAll()
    }

    @PostMapping
    fun addCopy(@RequestBody copy: Copy): Copy {
        return copyService.save(copy)
    }

    @PutMapping("/{id}")
    fun updateCopy(@PathVariable id: Long, @RequestBody copy: Copy): Copy {
        copyService.findById(id).let {
            it.store = copy.store
            it.price = copy.price
            return copyService.save(it)
        }
    }

    @DeleteMapping("/{id}")
    fun removeCopy(@PathVariable id: Long) {
        copyService.deleteById(id)
    }
}