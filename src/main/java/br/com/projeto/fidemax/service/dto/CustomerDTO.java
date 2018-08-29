package br.com.projeto.fidemax.service.dto;

import lombok.Data;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
public class CustomerDTO implements Serializable {

    private Long id;

    @NotNull
    @Pattern(regexp = "^[0-9]{11}$")
    private String cpf;

    @Lob
    private byte[] image;
    private String imageContentType;

    private Long portfolioId;

}
