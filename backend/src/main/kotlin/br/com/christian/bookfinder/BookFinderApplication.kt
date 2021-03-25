package br.com.christian.bookfinder

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BookFinderApplication

fun main(args: Array<String>) {
	runApplication<BookFinderApplication>(*args)
}
