package com.barbosa.Gerenciador.de.membros.service;

import com.barbosa.Gerenciador.de.membros.model.Membro;
import com.barbosa.Gerenciador.de.membros.repository.MembroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MembroService {

    private MembroRepository membroRepository;

    public Membro saveMembro(Membro membro) {
        return membroRepository.save(membro);
    }

    public List<Membro> listarMembros() {
        return membroRepository.findAll();
    }
}
