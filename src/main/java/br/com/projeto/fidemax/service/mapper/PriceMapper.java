package br.com.projeto.fidemax.service.mapper;

import br.com.projeto.fidemax.domain.Price;
import br.com.projeto.fidemax.service.dto.PriceDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PriceMapper extends EntityMapper<PriceDTO, Price> {

    @Mapping(source = "product.id", target = "productId")
    PriceDTO toDto(Price price);

    @Mapping(source = "productId", target = "product")
    Price toEntity(PriceDTO priceDTO);

    default Price fromId(Long id) {
        if (id == null) {
            return null;
        }
        Price price = new Price();
        price.setId(id);
        return price;
    }
}
