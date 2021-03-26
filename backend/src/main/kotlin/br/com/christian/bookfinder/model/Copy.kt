package br.com.christian.bookfinder.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "copy")
data class Copy (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    val id: Long,

    @ManyToOne
    @JoinColumn(name = "book_id")
    val book: Book,

    @ManyToOne
    @JoinColumn(name = "store_id")
    @JsonIgnore
    var store: Store,

    @Column(name="price", nullable = false)
    var price: Double
)
