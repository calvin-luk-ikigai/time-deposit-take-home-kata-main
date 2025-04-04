package org.ikigaidigital.application;

import org.ikigaidigital.application.port.driven.TimeDepositPort;
import org.ikigaidigital.application.port.driving.TimeDepositUseCase;
import org.ikigaidigital.domain.TimeDeposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeDepositService implements TimeDepositUseCase {

    @Autowired
    private TimeDepositPort timeDepositPort;

    @Override
    public void updateBalances() {
        timeDepositPort.updateBalances();
    }

    @Override
    public List<TimeDeposit> getAllTimeDeposits() {
        return timeDepositPort.getAllTimeDeposits();
    }
}
