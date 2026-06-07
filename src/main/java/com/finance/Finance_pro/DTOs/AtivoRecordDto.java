package com.finance.Finance_pro.DTOs;

import com.finance.Finance_pro.Models.Ativo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record AtivoRecordDto(
        @NotBlank String nome,
        @NotBlank String codigo,
        @NotNull @PositiveOrZero BigDecimal precoMedio,
        @NotNull @PositiveOrZero Integer quantidade
) {}
