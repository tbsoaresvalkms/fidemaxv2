package br.com.projeto.fidemax.service;

import br.com.projeto.fidemax.service.dto.CustomerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CustomerService {

    CustomerDTO save(CustomerDTO customerDTO);

    Page<CustomerDTO> findAll(Pageable pageable);

    Optional<CustomerDTO> findOne(Long id);

    void delete(Long id);
}
