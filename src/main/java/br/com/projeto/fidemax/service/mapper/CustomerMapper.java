package br.com.projeto.fidemax.service.mapper;

import br.com.projeto.fidemax.domain.Customer;
import br.com.projeto.fidemax.service.dto.CustomerDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {PortfolioMapper.class})
public interface CustomerMapper extends EntityMapper<CustomerDTO, Customer> {

    @Mapping(source = "portfolio.id", target = "portfolioId")
    CustomerDTO toDto(Customer customer);

    @Mapping(source = "portfolioId", target = "portfolio")
    Customer toEntity(CustomerDTO customerDTO);

    default Customer fromId(Long id) {
        if (id == null) {
            return null;
        }
        Customer customer = new Customer();
        customer.setId(id);
        return customer;
    }
}
