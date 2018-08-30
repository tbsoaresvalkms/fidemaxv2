package br.com.projeto.fidemax.domain;

import br.com.projeto.fidemax.domain.enumeration.Office;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "employee")
@Data
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "office")
    private Office office;

    @OneToMany(mappedBy = "employee")
    private Set<ConsumerTransaction> consumerTransactions = new HashSet<>();

    @ManyToOne(optional = false)
    @NotNull
    private Company company;

}
