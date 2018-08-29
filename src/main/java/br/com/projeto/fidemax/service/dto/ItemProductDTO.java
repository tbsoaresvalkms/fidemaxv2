package br.com.projeto.fidemax.service.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ItemProductDTO implements Serializable {

    private Long id;

    @NotNull
    @Min(value = 0)
    private Integer count;

    private BigDecimal unitPrice;

    private Long productId;

}
