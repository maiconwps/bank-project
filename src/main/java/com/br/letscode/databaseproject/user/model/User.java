package com.br.letscode.databaseproject.user.model;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "usuario")
@Entity
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cpf", unique = true)
    private String cpf;

    @Column(name = "nome")
    private String name;

    @Column(name = "data_criacao")
    @CreatedDate
    private LocalDateTime creationDate;

    @Column(name = "data_atualizacao")
    @LastModifiedDate
    private LocalDateTime updateDate;
}
