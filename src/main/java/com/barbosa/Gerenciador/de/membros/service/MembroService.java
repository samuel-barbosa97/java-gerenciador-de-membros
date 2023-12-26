package com.barbosa.Gerenciador.de.membros.service;

import com.barbosa.Gerenciador.de.membros.model.Membro;
import com.barbosa.Gerenciador.de.membros.model.UpdateMembro;
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

    public Membro updateMembro(UpdateMembro updateMembro, String id) throws Exception {
        Membro membroToBeUpdated = membroRepository.findById(id)
                .orElseThrow(() -> new Exception("The id do not exist in database"));
        membroToBeUpdated.setName(updateMembro.getName());
        membroToBeUpdated.setDescription(updateMembro.getDescription());
        membroToBeUpdated.setAge(updateMembro.getAge());
        return membroRepository.save(membroToBeUpdated);
    }
}
