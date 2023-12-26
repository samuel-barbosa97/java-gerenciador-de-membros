package com.barbosa.Gerenciador.de.membros.controller;

import com.barbosa.Gerenciador.de.membros.model.Membro;
import com.barbosa.Gerenciador.de.membros.model.UpdateMembro;
import com.barbosa.Gerenciador.de.membros.service.MembroService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/membros")
@AllArgsConstructor
public class MembroController {

    private MembroService membroService;

    @PostMapping
    public Membro saveMembro(@RequestBody Membro membro) {
        return membroService.saveMembro(membro);
    }

    @GetMapping
    public List<Membro> listMembros() {
        return membroService.listarMembros();
    }

    @PutMapping("/{id}")
    public Membro updateMembro(@RequestBody UpdateMembro updateMembro, @PathVariable("id") String id) throws Exception {
        return membroService.updateMembro(updateMembro, id);
    }

    @DeleteMapping("/{id}")
    public void deleteMembro(@PathVariable("id") String id) {
        membroService.deleteMembro(id);
    }
}
