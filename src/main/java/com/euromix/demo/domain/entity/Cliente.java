package com.euromix.demo.domain.entity;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private Integer id;
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }
}
