package br.com.projeto.fidemax.service.dto;

import br.com.projeto.fidemax.domain.enumeration.Office;
import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeeDTO implements Serializable {

    private Long id;

    private Office office;

    private Long companyId;

}
