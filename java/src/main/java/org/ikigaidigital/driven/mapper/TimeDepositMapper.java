package org.ikigaidigital.driven.mapper;

import org.ikigaidigital.domain.TimeDeposit;
import org.ikigaidigital.driven.entity.TimeDepositEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TimeDepositMapper {
    public TimeDeposit map(TimeDepositEntity timeDepositEntity) {
        return new TimeDeposit(timeDepositEntity.getId(), timeDepositEntity.getPlanType(), timeDepositEntity.getBalance().doubleValue(), timeDepositEntity.getDays());
    }

    public List<TimeDeposit> map(List<TimeDepositEntity> timeDepositEntityList) {
        return timeDepositEntityList.stream()
                .map(timeDepositEntity -> new TimeDeposit(
                        timeDepositEntity.getId(),
                        timeDepositEntity.getPlanType(),
                        timeDepositEntity.getBalance().doubleValue(),
                        timeDepositEntity.getDays()
                ))
                .collect(Collectors.toList());
    }
}
