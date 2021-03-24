package br.com.christian.bookfinder.repository

import br.com.christian.bookfinder.model.Store
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StoreRepository : JpaRepository<Store, Long> {
}
