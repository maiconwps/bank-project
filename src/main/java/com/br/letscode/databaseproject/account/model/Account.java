package com.br.letscode.databaseproject.account.model;

import com.br.letscode.databaseproject.shared.exceptions.SemanticError;
import com.br.letscode.databaseproject.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "conta")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero")
    private Integer number;

    @Column(name = "agencia")
    private Integer agency;

    @Column(name = "tipo_conta")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(name = "saldo")
    private BigDecimal balance;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private User user;


    @Column(name = "data_criacao")
    @CreatedDate
    private LocalDateTime creationDate;

    @Column(name = "data_atualizacao")
    @LastModifiedDate
    private LocalDateTime updateDate;

    public void withdraw(BigDecimal value) throws SemanticError {
        if(value.compareTo(this.balance) > 0){
            throw new SemanticError("balance", "Saldo insuficiente");
        }
        this.balance = this.balance.subtract(value);
    }

    public void deposit(BigDecimal value) {
        this.balance = this.balance.add(value);
    }
}
