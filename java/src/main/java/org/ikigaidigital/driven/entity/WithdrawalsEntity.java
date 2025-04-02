package org.ikigaidigital.driven.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "withdrawals")
public class WithdrawalsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "timeDepositId", nullable = false)
    private TimeDepositEntity timeDepositEntity;

    private BigDecimal amount;

    private Date date;

    public Integer getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }
}
