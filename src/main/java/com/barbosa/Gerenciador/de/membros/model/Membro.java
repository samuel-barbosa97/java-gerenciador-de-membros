package com.barbosa.Gerenciador.de.membros.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "membros")
public class Membro {
    @Id
    private String id;
    private String name;
    private String description;
    private Integer age;

    public Membro(String name, String description, Integer age) {
        this.name = name;
        this.description = description;
        this.age = age;
    }
}
