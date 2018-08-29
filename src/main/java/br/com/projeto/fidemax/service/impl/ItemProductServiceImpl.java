package br.com.projeto.fidemax.service.impl;

import br.com.projeto.fidemax.domain.ItemProduct;
import br.com.projeto.fidemax.repository.ItemProductRepository;
import br.com.projeto.fidemax.service.ItemProductService;
import br.com.projeto.fidemax.service.dto.ItemProductDTO;
import br.com.projeto.fidemax.service.mapper.ItemProductMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ItemProductServiceImpl implements ItemProductService {

    private final Logger log = LoggerFactory.getLogger(ItemProductServiceImpl.class);

    private final ItemProductRepository itemProductRepository;

    private final ItemProductMapper itemProductMapper;

    public ItemProductServiceImpl(ItemProductRepository itemProductRepository, ItemProductMapper itemProductMapper) {
        this.itemProductRepository = itemProductRepository;
        this.itemProductMapper = itemProductMapper;
    }

    @Override
    public ItemProductDTO save(ItemProductDTO itemProductDTO) {
        log.debug("Request to save ItemProduct : {}", itemProductDTO);
        ItemProduct itemProduct = itemProductMapper.toEntity(itemProductDTO);
        itemProduct = itemProductRepository.save(itemProduct);
        return itemProductMapper.toDto(itemProduct);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ItemProductDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ItemProducts");
        return itemProductRepository.findAll(pageable)
            .map(itemProductMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ItemProductDTO> findOne(Long id) {
        log.debug("Request to get ItemProduct : {}", id);
        return itemProductRepository.findById(id)
            .map(itemProductMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ItemProduct : {}", id);
        itemProductRepository.deleteById(id);
    }
}
