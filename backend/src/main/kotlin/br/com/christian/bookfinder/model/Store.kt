package br.com.christian.bookfinder.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "store")
data class Store (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name="name", nullable = false)
    var name: String,

    @OneToMany(mappedBy="store", cascade = [CascadeType.ALL])
    @JsonIgnore
    val copys: List<Copy>
)
