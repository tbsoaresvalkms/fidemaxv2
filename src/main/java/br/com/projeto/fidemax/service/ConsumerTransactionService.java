package br.com.projeto.fidemax.service;

import br.com.projeto.fidemax.service.dto.ConsumerTransactionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ConsumerTransactionService {

    ConsumerTransactionDTO save(ConsumerTransactionDTO consumerTransactionDTO);

    Page<ConsumerTransactionDTO> findAll(Pageable pageable);

    Optional<ConsumerTransactionDTO> findOne(Long id);

    void delete(Long id);
}
