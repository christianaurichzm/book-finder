package br.com.christian.bookfinder.controller

import br.com.christian.bookfinder.model.Book
import br.com.christian.bookfinder.model.Copy
import br.com.christian.bookfinder.service.BookServiceImpl
import br.com.christian.bookfinder.service.CopyServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/copys")
class CopyController {
    @Autowired
    lateinit var copyService: CopyServiceImpl

    @GetMapping("/{id}")
    fun getBook(@PathVariable id: Long): Copy {
        return copyService.findById(id)
    }

    @PostMapping
    fun addBook(@RequestBody copy: Copy): Copy {
        copyService.save(copy)
        return copy
    }
}