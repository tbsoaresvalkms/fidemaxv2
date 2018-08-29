package br.com.projeto.fidemax.repository;

import br.com.projeto.fidemax.domain.ItemProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemProductRepository extends JpaRepository<ItemProduct, Long> {

}
