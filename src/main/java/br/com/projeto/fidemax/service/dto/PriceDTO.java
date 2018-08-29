package br.com.projeto.fidemax.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PriceDTO implements Serializable {

    private Long id;

    private LocalDate date;

    private BigDecimal unitPrice;

    private Long productId;

}
