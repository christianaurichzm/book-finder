package br.com.christian.bookfinder.service

import br.com.christian.bookfinder.model.Copy
import br.com.christian.bookfinder.repository.CopyRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CopyServiceImpl : CopyService {
    @Autowired
    lateinit var copyRepository: CopyRepository

    @Transactional
    override fun findAll(): List<Copy> {
        return copyRepository.findAll()
    }

    @Transactional
    override fun findById(id: Long): Copy {
        return copyRepository.findById(id).get()
    }

    @Transactional
    override fun save(copy: Copy): Copy {
        return copyRepository.save(copy)
    }

    @Transactional
    override fun deleteById(id: Long) {
        copyRepository.deleteById(id)
    }
}