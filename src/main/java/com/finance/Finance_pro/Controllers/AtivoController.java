package com.finance.Finance_pro.Controllers;

import com.finance.Finance_pro.DTOs.AtivoRecordDto;
import com.finance.Finance_pro.Models.Ativo;
import com.finance.Finance_pro.Services.AtivoService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ativos")
public class AtivoController {

    private final AtivoService ativoService;

    public AtivoController(AtivoService ativoService) {
        this.ativoService = ativoService;
    }

    @PostMapping
    public ResponseEntity<Ativo> salvarAtivo(@RequestBody @Valid AtivoRecordDto ativoRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ativoService.salvar(ativoRecordDto));
    }

    @GetMapping
    public ResponseEntity<List<Ativo>> listarAtivos() {
        return ResponseEntity.status(HttpStatus.OK).body(ativoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ativo> listarPorId(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(ativoService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ativo> atualizar(@PathVariable UUID id, @RequestBody @Valid AtivoRecordDto ativoRecordDto) {
        return ResponseEntity.status(HttpStatus.OK).body(ativoService.atualizar(id, ativoRecordDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        ativoService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
