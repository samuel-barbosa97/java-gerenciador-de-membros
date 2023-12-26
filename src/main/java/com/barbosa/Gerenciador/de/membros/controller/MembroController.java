package com.barbosa.Gerenciador.de.membros.controller;

import com.barbosa.Gerenciador.de.membros.model.Membro;
import com.barbosa.Gerenciador.de.membros.model.UpdateMembro;
import com.barbosa.Gerenciador.de.membros.service.MembroService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/membros")
@Api(tags = "Membros", value = "Operações relacionadas a membros")
@AllArgsConstructor
public class MembroController {

    private MembroService membroService;

    @PostMapping
    public ResponseEntity<Membro> saveMembro(@RequestBody Membro membro) {
        Membro savedMembro = membroService.saveMembro(membro);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMembro);
    }

    @GetMapping
    public ResponseEntity<List<Membro>> listMembros() {
        List<Membro> membros = membroService.listarMembros();
        return ResponseEntity.status(HttpStatus.OK).body(membros);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Membro> updateMembro(@RequestBody UpdateMembro updateMembro, @PathVariable("id") String id) {
        try {
            Membro updatedMembro = membroService.updateMembro(updateMembro, id);
            return ResponseEntity.status(HttpStatus.OK).body(updatedMembro);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMembro(@PathVariable("id") String id) {
        try {
            membroService.deleteMembro(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
