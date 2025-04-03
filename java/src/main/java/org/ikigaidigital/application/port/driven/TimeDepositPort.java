package org.ikigaidigital.application.port.driven;

import org.ikigaidigital.domain.TimeDeposit;

import java.util.List;

public interface TimeDepositPort {
    void updateBalances();

    List<TimeDeposit> getAllTimeDeposits();
}
