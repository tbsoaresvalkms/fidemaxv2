package br.com.projeto.fidemax.service;

import br.com.projeto.fidemax.service.dto.PriceDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PriceService {

    PriceDTO save(PriceDTO priceDTO);

    Page<PriceDTO> findAll(Pageable pageable);

    Optional<PriceDTO> findOne(Long id);

    void delete(Long id);
}
