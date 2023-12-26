package com.barbosa.Gerenciador.de.membros.repository;

import com.barbosa.Gerenciador.de.membros.model.Membro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembroRepository extends MongoRepository<Membro, String> {
}
