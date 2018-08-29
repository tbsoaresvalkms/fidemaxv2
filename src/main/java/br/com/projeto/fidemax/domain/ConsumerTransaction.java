package br.com.projeto.fidemax.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "consumer_transaction")
@Data
public class ConsumerTransaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @NotNull
    @DecimalMin(value = "0")
    @Column(name = "balance", precision = 10, scale = 2, nullable = false)
    private BigDecimal balance;

    @OneToOne(optional = false)
    @NotNull
    @JoinColumn(unique = true)
    private Employee employee;

    @ManyToOne(optional = false)
    @NotNull
    private Portfolio portfolio;

    @ManyToOne(optional = false)
    @NotNull
    private Company company;

}
