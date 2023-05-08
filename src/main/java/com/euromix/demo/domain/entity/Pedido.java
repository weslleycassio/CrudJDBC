package com.euromix.demo.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente clienteId;
    @Column(name = "data_pedido")
    private LocalDate data;
    @Column(name = "total", length = 20, precision = 2)
    private BigDecimal total;


}
