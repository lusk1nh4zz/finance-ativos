package com.finance.Finance_pro.Models;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "tb_ativos")
@NoArgsConstructor
@AllArgsConstructor
public class Ativo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "codigo", nullable = false, length = 10)
    private String codigo;

    @Column(name = "preço_medio", nullable = false)
    private BigDecimal precoMedio;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;
}
