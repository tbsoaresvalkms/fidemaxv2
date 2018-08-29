package br.com.projeto.fidemax.service.mapper;

import br.com.projeto.fidemax.domain.ItemProduct;
import br.com.projeto.fidemax.service.dto.ItemProductDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface ItemProductMapper extends EntityMapper<ItemProductDTO, ItemProduct> {

    @Mapping(source = "product.id", target = "productId")
    ItemProductDTO toDto(ItemProduct itemProduct);

    @Mapping(source = "productId", target = "product")
    @Mapping(target = "redemptionTransaction", ignore = true)
    ItemProduct toEntity(ItemProductDTO itemProductDTO);

    default ItemProduct fromId(Long id) {
        if (id == null) {
            return null;
        }
        ItemProduct itemProduct = new ItemProduct();
        itemProduct.setId(id);
        return itemProduct;
    }
}
