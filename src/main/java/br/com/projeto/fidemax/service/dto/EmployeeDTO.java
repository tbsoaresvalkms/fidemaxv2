package br.com.projeto.fidemax.service.dto;

import br.com.projeto.fidemax.domain.enumeration.Office;
import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeeDTO implements Serializable {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String password;


    private Office office;

    private Long companyId;

}
