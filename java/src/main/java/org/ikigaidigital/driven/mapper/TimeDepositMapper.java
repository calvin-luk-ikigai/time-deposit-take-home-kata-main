package org.ikigaidigital.driven.mapper;

import org.ikigaidigital.domain.TimeDeposit;
import org.ikigaidigital.driven.entity.TimeDepositEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TimeDepositMapper {
    public TimeDeposit map(TimeDepositEntity timeDepositEntity) {
        return new TimeDeposit(timeDepositEntity.getId(), timeDepositEntity.getPlanType(), timeDepositEntity.getBalance().doubleValue(), timeDepositEntity.getDays());
    }

    public List<TimeDeposit> map(List<TimeDepositEntity> timeDepositEntityList) {
        return timeDepositEntityList.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    public List<TimeDepositEntity> mapToEntity(List<TimeDeposit> timeDepositList) {
        return timeDepositList.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toList());
    }

    public TimeDepositEntity mapToEntity(TimeDeposit timeDeposit) {
        TimeDepositEntity timeDepositEntity = new TimeDepositEntity();
        timeDepositEntity.setId(timeDeposit.getId());
        timeDepositEntity.setPlanType(timeDeposit.getPlanType());
        timeDepositEntity.setBalance(BigDecimal.valueOf(timeDeposit.getBalance()));
        timeDepositEntity.setDays(timeDeposit.getDays());
        return timeDepositEntity;
    }
}
