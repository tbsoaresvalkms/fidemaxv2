package br.com.projeto.fidemax.domain;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

@Entity
@Table(name = "customer")
@Data
public class Customer implements Serializable {

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

    @NotNull
    @Pattern(regexp = "^[0-9]{11}$")
    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name = "image_content_type")
    private String imageContentType;

    @OneToOne(optional = false)
    @NotNull
    @JoinColumn(unique = true)
    private Portfolio portfolio;
}
