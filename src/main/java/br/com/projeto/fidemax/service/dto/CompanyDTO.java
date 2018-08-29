package br.com.projeto.fidemax.service.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class CompanyDTO implements Serializable {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String cnpj;
}
