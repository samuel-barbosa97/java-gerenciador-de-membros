package com.barbosa.Gerenciador.de.membros.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMembro {
    private String name;
    private String description;
    private Integer age;
}
