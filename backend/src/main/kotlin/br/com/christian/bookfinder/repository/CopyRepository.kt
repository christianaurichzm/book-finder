package br.com.christian.bookfinder.repository

import br.com.christian.bookfinder.model.Copy
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CopyRepository : JpaRepository<Copy, Long> {
}
