package com.br.letscode.databaseproject.transaction.model;

import com.br.letscode.databaseproject.account.model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "transacao")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "valor")
    private BigDecimal value;

    @Column(name = "tipo_transacao")
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Column(name = "numero")
    private Integer number;

    @Column(name = "agencia")
    private Integer agency;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "conta_id", referencedColumnName = "id")
    private Account account;

    @Column(name = "data_criacao")
    @CreatedDate
    private LocalDateTime creationDate;

    @Column(name = "data_atualizacao")
    @LastModifiedDate
    private LocalDateTime updateDate;
}
