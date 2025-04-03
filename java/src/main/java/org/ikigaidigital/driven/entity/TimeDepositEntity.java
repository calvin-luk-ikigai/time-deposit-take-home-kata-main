package org.ikigaidigital.driven.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "timeDeposits")
public class TimeDepositEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String planType;

    @Column(nullable = false)
    private BigDecimal balance;

    @Column(nullable = false)
    private int days;

    public void setId(int id) {
        this.id = id;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Integer getId() {
        return id;
    }

    public String getPlanType() {
        return planType;
    }

    public Integer getDays() {
        return days;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public TimeDepositEntity() {

    }

    public TimeDepositEntity(int id, String planType, BigDecimal balance, int days) {
        this.id = id;
        this.planType = planType;
        this.balance = balance;
        this.days = days;
    }
}
