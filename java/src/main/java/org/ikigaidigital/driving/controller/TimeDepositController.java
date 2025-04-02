package org.ikigaidigital.driving.controller;

import org.ikigaidigital.application.port.driving.TimeDepositUseCase;
import org.ikigaidigital.domain.TimeDeposit;
import org.ikigaidigital.driving.dto.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TimeDepositController {

    @Autowired
    private TimeDepositUseCase timeDepositUseCase;

    @PostMapping("/time-deposits/update-all-balances")
    public void updateAllBalances(@RequestBody UpdateRequest request) {
        timeDepositUseCase.updateBalances(request.getBalance());
    }

    @GetMapping("/time-deposits")
    public List<TimeDeposit> getAllTimeDeposits() {
        return timeDepositUseCase.getAllTimeDeposits();
    }
}