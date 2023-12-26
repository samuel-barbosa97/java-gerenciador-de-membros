package com.barbosa.Gerenciador.de.membros.controller;

import com.barbosa.Gerenciador.de.membros.model.Membro;
import com.barbosa.Gerenciador.de.membros.service.MembroService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/membros")
@AllArgsConstructor
public class MembroController {

    private MembroService membroService;

    @PostMapping
    public Membro saveMembro(@RequestBody Membro membro) {
        return membroService.saveMembro(membro);
    }
}
