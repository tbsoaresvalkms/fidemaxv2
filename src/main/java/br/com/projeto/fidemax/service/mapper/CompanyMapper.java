package br.com.projeto.fidemax.service.mapper;

import br.com.projeto.fidemax.domain.Company;
import br.com.projeto.fidemax.service.dto.CompanyDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CompanyMapper extends EntityMapper<CompanyDTO, Company> {


    @Mapping(target = "consumerTransactions", ignore = true)
    @Mapping(target = "redemptionTransactions", ignore = true)
    @Mapping(target = "employees", ignore = true)
    Company toEntity(CompanyDTO companyDTO);

    default Company fromId(Long id) {
        if (id == null) {
            return null;
        }
        Company company = new Company();
        company.setId(id);
        return company;
    }
}
