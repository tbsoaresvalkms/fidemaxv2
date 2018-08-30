package br.com.projeto.fidemax.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "company")
@Data
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "cnpj", nullable = false)
    private String cnpj;

    @OneToMany(mappedBy = "company")
    private Set<ConsumerTransaction> consumerTransactions = new HashSet<>();

    @OneToMany(mappedBy = "company")
    private Set<RedemptionTransaction> redemptionTransactions = new HashSet<>();

    @OneToMany(mappedBy = "company")
    private Set<Employee> employees = new HashSet<>();

    @OneToMany(mappedBy = "company")
    private Set<Product> products = new HashSet<>();
}
