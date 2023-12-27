package com.barbosa.Gerenciador.de.membros.service;

import com.barbosa.Gerenciador.de.membros.model.Membro;
import com.barbosa.Gerenciador.de.membros.model.UpdateMembro;
import com.barbosa.Gerenciador.de.membros.repository.MembroRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void deleteMembro(String id) {
        membroRepository.deleteById(id);
    }

    public Membro getMembroById(String id) throws ChangeSetPersister.NotFoundException {
        Optional<Membro> membroOptional = membroRepository.findById(id);
        if (membroOptional.isPresent()) {
            return membroOptional.get();
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

}
