package br.com.christian.bookfinder.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
data class Copy (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne
    @JoinColumn(name = "book_id")
    val book: Book,

    @ManyToOne
    @JoinColumn(name = "store_id")
    val store: Store,

    @Column(nullable = false)
    val price: Double
)
