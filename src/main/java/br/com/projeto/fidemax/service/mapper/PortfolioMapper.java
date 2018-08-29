package br.com.projeto.fidemax.service.mapper;

import br.com.projeto.fidemax.domain.Portfolio;
import br.com.projeto.fidemax.service.dto.PortfolioDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PortfolioMapper extends EntityMapper<PortfolioDTO, Portfolio> {


    @Mapping(target = "consumerTransactions", ignore = true)
    @Mapping(target = "redemptionTransactions", ignore = true)
    @Mapping(target = "customer", ignore = true)
    Portfolio toEntity(PortfolioDTO portfolioDTO);

    default Portfolio fromId(Long id) {
        if (id == null) {
            return null;
        }
        Portfolio portfolio = new Portfolio();
        portfolio.setId(id);
        return portfolio;
    }
}
