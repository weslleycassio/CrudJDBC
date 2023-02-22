package com.euromix.demo.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class Pedido {

    private Integer id;
    private Cliente clienteId;
    private Date data;
    private BigDecimal total;

}
