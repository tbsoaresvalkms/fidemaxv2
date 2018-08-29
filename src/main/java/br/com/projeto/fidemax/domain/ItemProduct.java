package br.com.projeto.fidemax.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "item_product")
@Data
public class ItemProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Min(value = 0)
    @Column(name = "count", nullable = false)
    private Integer count;

    @Column(name = "unit_price", precision = 10, scale = 2)
    private BigDecimal unitPrice;

    @OneToOne(optional = false)
    @NotNull
    @JoinColumn(unique = true)
    private Product product;

    @OneToOne(mappedBy = "itemProduct")
    private RedemptionTransaction redemptionTransaction;
}
