package org.ikigaidigital.driven.adapter;

import org.ikigaidigital.application.port.driven.TimeDepositPort;
import org.ikigaidigital.domain.TimeDeposit;
import org.ikigaidigital.domain.TimeDepositCalculator;
import org.ikigaidigital.driven.entity.TimeDepositEntity;
import org.ikigaidigital.driven.mapper.TimeDepositMapper;
import org.ikigaidigital.driven.repository.TimeDepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TimeDepositAdapter implements TimeDepositPort {

    @Autowired
    private TimeDepositRepository timeDepositRepository;

    @Autowired
    private TimeDepositMapper timeDepositMapper;

    @Autowired
    private TimeDepositCalculator timeDepositCalculator;

    @Override
    @Transactional
    public void updateBalances() {
        List<TimeDepositEntity> timeDepositEntityList = timeDepositRepository.findAll();
        List<TimeDeposit> timeDeposits = timeDepositMapper.map(timeDepositEntityList);
        timeDepositCalculator.updateBalance(timeDeposits);

        timeDepositEntityList.forEach(entity -> {
            timeDeposits.stream()
                    .filter(timeDeposit -> entity.getId().equals(timeDeposit.getId()))
                    .findFirst()
                    .ifPresent(timeDeposit -> entity.setBalance(BigDecimal.valueOf(timeDeposit.getBalance())));
        });

        timeDepositRepository.saveAll(timeDepositEntityList);
    }

    @Override
    public List<TimeDeposit> getAllTimeDeposits() {
        return timeDepositMapper.map(timeDepositRepository.findAll());
    }
}
