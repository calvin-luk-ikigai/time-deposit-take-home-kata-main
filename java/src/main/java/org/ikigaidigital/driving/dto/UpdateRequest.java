package org.ikigaidigital.driving.dto;

import java.math.BigDecimal;

public class UpdateRequest {
    public UpdateRequest() {

    }

    public UpdateRequest(BigDecimal balance) {
        this.balance = balance;
    }

    private BigDecimal balance;

    public BigDecimal getBalance() {
        return balance;
    }
}
