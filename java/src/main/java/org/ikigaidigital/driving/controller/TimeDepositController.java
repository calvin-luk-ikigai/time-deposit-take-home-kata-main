package org.ikigaidigital.driving.controller;

import org.ikigaidigital.application.port.driving.TimeDepositUseCase;
import org.ikigaidigital.domain.TimeDeposit;
import org.ikigaidigital.driving.dto.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-deposits")
public class TimeDepositController {

    @Autowired
    private TimeDepositUseCase timeDepositUseCase;

    @PutMapping("/balances")
    public void updateAllBalances() {
        timeDepositUseCase.updateBalances();
    }

    @GetMapping
    public List<TimeDeposit> getAllTimeDeposits() {
        return timeDepositUseCase.getAllTimeDeposits();
    }
}