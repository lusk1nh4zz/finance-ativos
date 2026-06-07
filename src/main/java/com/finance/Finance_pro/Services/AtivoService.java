package com.finance.Finance_pro.Services;

import com.finance.Finance_pro.DTOs.AtivoRecordDto;
import com.finance.Finance_pro.Models.Ativo;
import com.finance.Finance_pro.Repositories.AtivoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AtivoService {

    private final AtivoRepository ativoRepository;

    public AtivoService(AtivoRepository ativoRepository) {
        this.ativoRepository = ativoRepository;
    }

    public Ativo salvar(AtivoRecordDto dto) {
        var ativo = new Ativo();
        BeanUtils.copyProperties(dto, ativo);
        return ativoRepository.save(ativo);
    }

    public List<Ativo> buscarTodos() {
        return ativoRepository.findAll();
    }

    public Ativo buscarPorId(UUID id) {
        return ativoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Ativo não encontrado"));
    }

    public void deletar(UUID id) {
        Ativo ativoExistente = buscarPorId(id);
        ativoRepository.delete(ativoExistente);
    }

    public Ativo atualizar(UUID id, AtivoRecordDto dto) {
        Ativo ativoExistente = buscarPorId(id);
        BeanUtils.copyProperties(dto, ativoExistente);
        return ativoRepository.save(ativoExistente);
    }
}
