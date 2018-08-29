package br.com.projeto.fidemax.service;

import br.com.projeto.fidemax.service.dto.RedemptionTransactionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface RedemptionTransactionService {

    RedemptionTransactionDTO save(RedemptionTransactionDTO redemptionTransactionDTO);

    Page<RedemptionTransactionDTO> findAll(Pageable pageable);

    Optional<RedemptionTransactionDTO> findOne(Long id);

    void delete(Long id);
}
