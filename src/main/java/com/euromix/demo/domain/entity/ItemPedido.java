package com.euromix.demo.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ItemPedido {

    private Integer id;
    private Pedido pedidoId;
    private Produto produtoId;
    private Integer Quantidade;
    private BigDecimal total;


}
