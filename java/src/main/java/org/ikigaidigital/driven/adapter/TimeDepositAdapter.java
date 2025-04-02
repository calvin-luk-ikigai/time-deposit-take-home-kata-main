package org.ikigaidigital.driven.adapter;

import org.ikigaidigital.application.port.driven.TimeDepositPort;
import org.ikigaidigital.domain.TimeDeposit;
import org.ikigaidigital.driven.entity.TimeDepositEntity;
import org.ikigaidigital.driven.mapper.TimeDepositMapper;
import org.ikigaidigital.driven.repository.TimeDepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TimeDepositAdapter implements TimeDepositPort {

    @Autowired
    private TimeDepositRepository timeDepositRepository;

    @Autowired
    private TimeDepositMapper timeDepositMapper;

    @Override
    public void updateBalances(BigDecimal balance) {
        List<TimeDepositEntity> timeDeposits = timeDepositRepository.findAll();
        timeDeposits.forEach(timeDeposit -> {
            timeDeposit.setBalance(balance);
        });

        timeDepositRepository.saveAll(timeDeposits);
    }

    @Override
    public List<TimeDeposit> getAllTimeDeposits() {
        return timeDepositMapper.map(timeDepositRepository.findAll());
    }
}
