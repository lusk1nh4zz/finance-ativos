package com.finance.Finance_pro.Repositories;

import com.finance.Finance_pro.Models.Ativo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AtivoRepository extends JpaRepository<Ativo, UUID> {
}
