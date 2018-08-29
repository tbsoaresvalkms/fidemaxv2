package br.com.projeto.fidemax.service.impl;

import br.com.projeto.fidemax.domain.ConsumerTransaction;
import br.com.projeto.fidemax.repository.ConsumerTransactionRepository;
import br.com.projeto.fidemax.service.ConsumerTransactionService;
import br.com.projeto.fidemax.service.dto.ConsumerTransactionDTO;
import br.com.projeto.fidemax.service.mapper.ConsumerTransactionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ConsumerTransactionServiceImpl implements ConsumerTransactionService {

    private final Logger log = LoggerFactory.getLogger(ConsumerTransactionServiceImpl.class);

    private final ConsumerTransactionRepository consumerTransactionRepository;

    private final ConsumerTransactionMapper consumerTransactionMapper;

    public ConsumerTransactionServiceImpl(ConsumerTransactionRepository consumerTransactionRepository, ConsumerTransactionMapper consumerTransactionMapper) {
        this.consumerTransactionRepository = consumerTransactionRepository;
        this.consumerTransactionMapper = consumerTransactionMapper;
    }

    @Override
    public ConsumerTransactionDTO save(ConsumerTransactionDTO consumerTransactionDTO) {
        log.debug("Request to save ConsumerTransaction : {}", consumerTransactionDTO);
        ConsumerTransaction consumerTransaction = consumerTransactionMapper.toEntity(consumerTransactionDTO);
        consumerTransaction = consumerTransactionRepository.save(consumerTransaction);
        return consumerTransactionMapper.toDto(consumerTransaction);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ConsumerTransactionDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ConsumerTransactions");
        return consumerTransactionRepository.findAll(pageable)
            .map(consumerTransactionMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ConsumerTransactionDTO> findOne(Long id) {
        log.debug("Request to get ConsumerTransaction : {}", id);
        return consumerTransactionRepository.findById(id)
            .map(consumerTransactionMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ConsumerTransaction : {}", id);
        consumerTransactionRepository.deleteById(id);
    }
}
