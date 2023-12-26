package com.barbosa.Gerenciador.de.membros;

import com.barbosa.Gerenciador.de.membros.controller.MembroController;
import com.barbosa.Gerenciador.de.membros.model.Membro;
import com.barbosa.Gerenciador.de.membros.model.UpdateMembro;
import com.barbosa.Gerenciador.de.membros.service.MembroService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class MembroControllerTest {

    @Mock
    private MembroService membroService;

    @InjectMocks
    private MembroController membroController;

    private MockMvc mockMvc;

    @Test
    void saveMembro() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(membroController).build();

        Membro membroToSave = new Membro();

        // Converte o objeto para JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String membroJson = objectMapper.writeValueAsString(membroToSave);

        when(membroService.saveMembro(any(Membro.class))).thenReturn(membroToSave);

        ResultActions result = mockMvc.perform(post("/membros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(membroJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(membroToSave.getName()))
                .andExpect(jsonPath("$.description").value(membroToSave.getDescription()))
                .andExpect(jsonPath("$.age").value(membroToSave.getAge()));
    }
    @Test
    void listMembros() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(membroController).build();

        List<Membro> membros = Arrays.asList(
                new Membro("John Doe", "A sample person", 25),
                new Membro("Jane Smith", "Another example individual", 30));

        // Configura o comportamento do serviço mockado
        when(membroService.listarMembros()).thenReturn(membros);

        // Realiza a requisição GET e verifica o resultado
        ResultActions result = mockMvc.perform(get("/membros"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("John Doe"))
                .andExpect(jsonPath("$[0].description").value("A sample person"))
                .andExpect(jsonPath("$[0].age").value(25))
                .andExpect(jsonPath("$[1].name").value("Jane Smith"))
                .andExpect(jsonPath("$[1].description").value("Another example individual"))
                .andExpect(jsonPath("$[1].age").value(30));
    }

    @Test
    void updateMembro() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(membroController).build();

        // Crie um objeto UpdateMembro para simular a requisição do cliente
        UpdateMembro updateMembro = new UpdateMembro("Jane Smith", "Another example individual", 22);

        // Converte o objeto para JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String updateMembroJson = objectMapper.writeValueAsString(updateMembro);

        // Crie um ID simulado para o caminho da requisição
        String memberId = "1";

        // Crie um objeto Membro simulado que seria retornado pelo serviço após a atualização
        Membro membroAtualizado = new Membro("Bob Johnson", "Yet another person", 28);

        // Configura o comportamento do serviço mockado
        when(membroService.updateMembro(any(UpdateMembro.class), any(String.class))).thenReturn(membroAtualizado);

        // Realiza a requisição PUT e verifica o resultado
        ResultActions result = mockMvc.perform(put("/membros/{id}", memberId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updateMembroJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Bob Johnson"))
                .andExpect(jsonPath("$.description").value("Yet another person"))
                .andExpect(jsonPath("$.age").value(28));

    }

    @Test
    void deleteMembro() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(membroController).build();

        // Crie um ID simulado para o caminho da requisição
        String memberId = "1";

        // Realiza a requisição DELETE e verifica o resultado
        ResultActions result = mockMvc.perform(delete("/membros/{id}", memberId))
                .andExpect(status().isOk());

        // Verifica se o serviço foi chamado com o ID correto
        verify(membroService).deleteMembro(memberId);
    }
}
