package br.com.projeto.fidemax.repository;

import br.com.projeto.fidemax.domain.ConsumerTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ConsumerTransactionRepository extends JpaRepository<ConsumerTransaction, Long> {

}
