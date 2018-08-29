package br.com.projeto.fidemax.service.mapper;

import br.com.projeto.fidemax.domain.Employee;
import br.com.projeto.fidemax.service.dto.EmployeeDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {CompanyMapper.class})
public interface EmployeeMapper extends EntityMapper<EmployeeDTO, Employee> {

    @Mapping(source = "company.id", target = "companyId")
    EmployeeDTO toDto(Employee employee);

    @Mapping(target = "consumerTransaction", ignore = true)
    @Mapping(source = "companyId", target = "company")
    Employee toEntity(EmployeeDTO employeeDTO);

    default Employee fromId(Long id) {
        if (id == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setId(id);
        return employee;
    }
}
