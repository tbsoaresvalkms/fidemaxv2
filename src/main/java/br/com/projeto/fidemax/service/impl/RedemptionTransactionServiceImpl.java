package br.com.projeto.fidemax.service.impl;

import br.com.projeto.fidemax.domain.RedemptionTransaction;
import br.com.projeto.fidemax.repository.RedemptionTransactionRepository;
import br.com.projeto.fidemax.service.RedemptionTransactionService;
import br.com.projeto.fidemax.service.dto.RedemptionTransactionDTO;
import br.com.projeto.fidemax.service.mapper.RedemptionTransactionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RedemptionTransactionServiceImpl implements RedemptionTransactionService {

    private final Logger log = LoggerFactory.getLogger(RedemptionTransactionServiceImpl.class);

    private final RedemptionTransactionRepository redemptionTransactionRepository;

    private final RedemptionTransactionMapper redemptionTransactionMapper;

    public RedemptionTransactionServiceImpl(RedemptionTransactionRepository redemptionTransactionRepository, RedemptionTransactionMapper redemptionTransactionMapper) {
        this.redemptionTransactionRepository = redemptionTransactionRepository;
        this.redemptionTransactionMapper = redemptionTransactionMapper;
    }

    @Override
    public RedemptionTransactionDTO save(RedemptionTransactionDTO redemptionTransactionDTO) {
        log.debug("Request to save RedemptionTransaction : {}", redemptionTransactionDTO);
        RedemptionTransaction redemptionTransaction = redemptionTransactionMapper.toEntity(redemptionTransactionDTO);
        redemptionTransaction = redemptionTransactionRepository.save(redemptionTransaction);
        return redemptionTransactionMapper.toDto(redemptionTransaction);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<RedemptionTransactionDTO> findAll(Pageable pageable) {
        log.debug("Request to get all RedemptionTransactions");
        return redemptionTransactionRepository.findAll(pageable)
            .map(redemptionTransactionMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<RedemptionTransactionDTO> findOne(Long id) {
        log.debug("Request to get RedemptionTransaction : {}", id);
        return redemptionTransactionRepository.findById(id)
            .map(redemptionTransactionMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete RedemptionTransaction : {}", id);
        redemptionTransactionRepository.deleteById(id);
    }
}
