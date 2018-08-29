package br.com.projeto.fidemax.service;

import br.com.projeto.fidemax.service.dto.CompanyDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CompanyService {

    CompanyDTO save(CompanyDTO companyDTO);

    Page<CompanyDTO> findAll(Pageable pageable);

    Optional<CompanyDTO> findOne(Long id);

    void delete(Long id);
}
