package br.com.projeto.fidemax.service.mapper;

import br.com.projeto.fidemax.domain.Product;
import br.com.projeto.fidemax.service.dto.ProductDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {


    @Mapping(target = "prices", ignore = true)
    Product toEntity(ProductDTO productDTO);

    default Product fromId(Long id) {
        if (id == null) {
            return null;
        }
        Product product = new Product();
        product.setId(id);
        return product;
    }
}
