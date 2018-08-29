package br.com.projeto.fidemax.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "portfolio")
@Data
public class Portfolio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @DecimalMin(value = "0")
    @Column(name = "balance", precision = 10, scale = 2, nullable = false)
    private BigDecimal balance;

    @OneToMany(mappedBy = "portfolio")
    private Set<ConsumerTransaction> consumerTransactions = new HashSet<>();

    @OneToMany(mappedBy = "portfolio")
    private Set<RedemptionTransaction> redemptionTransactions = new HashSet<>();

    @OneToOne(mappedBy = "portfolio")
    private Customer customer;

}
