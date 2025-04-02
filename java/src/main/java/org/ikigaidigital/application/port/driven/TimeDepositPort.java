package org.ikigaidigital.application.port.driven;

import org.ikigaidigital.domain.TimeDeposit;

import java.math.BigDecimal;
import java.util.List;

public interface TimeDepositPort {
    void updateBalances(BigDecimal balance);

    List<TimeDeposit> getAllTimeDeposits();
}
