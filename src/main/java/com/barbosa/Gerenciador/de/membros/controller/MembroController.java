package com.barbosa.Gerenciador.de.membros.controller;

import com.barbosa.Gerenciador.de.membros.model.Membro;
import com.barbosa.Gerenciador.de.membros.model.UpdateMembro;
import com.barbosa.Gerenciador.de.membros.service.MembroService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.crossstore.ChangeSetPersister;
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

    private static final Logger logger = LoggerFactory.getLogger(MembroController.class);

    @PostMapping
    public ResponseEntity<Membro> saveMembro(@RequestBody Membro membro) {
        logger.info("Recebendo solicitação para salvar membro: {}", membro);

        Membro savedMembro = membroService.saveMembro(membro);

        logger.info("Membro salvo com sucesso: {}", savedMembro);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedMembro);
    }

    @GetMapping
    public ResponseEntity<List<Membro>> listMembros() {
        logger.info("Recebendo solicitação para listar membros.");

        List<Membro> membros = membroService.listarMembros();

        if (membros.isEmpty()) {
            logger.info("Nenhum membro encontrado.");
            return ResponseEntity.noContent().build();
        } else {
            logger.info("Listagem de membros bem-sucedida: {}", membros);
            return ResponseEntity.status(HttpStatus.OK).body(membros);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Membro> getMembroById(@PathVariable("id") String id) {
        try {
            logger.info("Buscando membro por ID: {}", id);
            Membro membro = membroService.getMembroById(id);
            logger.info("Membro encontrado: {}", membro);
            return ResponseEntity.status(HttpStatus.OK).body(membro);
        } catch (ChangeSetPersister.NotFoundException ex) {
            logger.warn("Membro não encontrado com ID: {}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception ex) {
            logger.error("Erro ao buscar membro por ID: {}", id, ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Membro> updateMembro(@RequestBody UpdateMembro updateMembro, @PathVariable("id") String id) {
        try {
            logger.info("Recebendo solicitação para atualizar membro com ID: {}", id);

            Membro updatedMembro = membroService.updateMembro(updateMembro, id);

            logger.info("Atualização de membro bem-sucedida. ID: {}, Membro atualizado: {}", id, updatedMembro);

            return ResponseEntity.status(HttpStatus.OK).body(updatedMembro);
        } catch (Exception ex) {
            logger.error("Erro ao processar a solicitação de atualização de membro. ID: {}", id, ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMembro(@PathVariable("id") String id) {
        try {
            logger.info("Recebendo solicitação para excluir membro com ID: {}", id);

            membroService.deleteMembro(id);

            logger.info("Exclusão de membro bem-sucedida. ID: {}", id);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception ex) {
            logger.error("Erro ao processar a solicitação de exclusão de membro. ID: {}", id, ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
