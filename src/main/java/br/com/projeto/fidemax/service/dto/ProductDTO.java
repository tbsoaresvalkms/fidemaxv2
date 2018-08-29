package br.com.projeto.fidemax.service.dto;

import lombok.Data;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class ProductDTO implements Serializable {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @Lob
    private byte[] image;
    private String imageContentType;

}
