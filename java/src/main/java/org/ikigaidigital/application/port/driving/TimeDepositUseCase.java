package org.ikigaidigital.application.port.driving;

import org.ikigaidigital.domain.TimeDeposit;

import java.math.BigDecimal;
import java.util.List;

public interface TimeDepositUseCase {
    void updateBalances(BigDecimal balance);

    List<TimeDeposit> getAllTimeDeposits();
}
