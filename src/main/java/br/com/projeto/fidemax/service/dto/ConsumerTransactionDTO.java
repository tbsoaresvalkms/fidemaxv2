package br.com.projeto.fidemax.service.dto;

import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ConsumerTransactionDTO implements Serializable {

    private Long id;

    private LocalDate date;

    @NotNull
    @DecimalMin(value = "0")
    private BigDecimal balance;

    private Long employeeId;

    private Long portfolioId;

    private Long companyId;
}

