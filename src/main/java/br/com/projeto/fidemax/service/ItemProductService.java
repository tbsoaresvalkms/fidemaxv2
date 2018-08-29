package br.com.projeto.fidemax.service;

import br.com.projeto.fidemax.service.dto.ItemProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ItemProductService {

    ItemProductDTO save(ItemProductDTO itemProductDTO);

    Page<ItemProductDTO> findAll(Pageable pageable);

    Optional<ItemProductDTO> findOne(Long id);

    void delete(Long id);
}
