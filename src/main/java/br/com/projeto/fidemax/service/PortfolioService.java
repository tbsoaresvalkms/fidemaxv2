package br.com.projeto.fidemax.service;

import br.com.projeto.fidemax.service.dto.PortfolioDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PortfolioService {

    PortfolioDTO save(PortfolioDTO portfolioDTO);

    Page<PortfolioDTO> findAll(Pageable pageable);

    Optional<PortfolioDTO> findOne(Long id);

    void delete(Long id);
}
