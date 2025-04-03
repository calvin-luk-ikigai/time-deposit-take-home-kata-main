package org.ikigaidigital.application.port.driving;

import org.ikigaidigital.domain.TimeDeposit;

import java.util.List;

public interface TimeDepositUseCase {
    void updateBalances();

    List<TimeDeposit> getAllTimeDeposits();
}
