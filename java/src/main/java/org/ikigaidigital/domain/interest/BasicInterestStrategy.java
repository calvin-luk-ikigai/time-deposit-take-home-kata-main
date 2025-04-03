package org.ikigaidigital.domain.interest;

import org.ikigaidigital.domain.TimeDeposit;

public class BasicInterestStrategy implements InterestCalculationStrategy {
    @Override
    public double calculateInterest(TimeDeposit timeDeposit) {
        return timeDeposit.getBalance() * 0.01 / 12;
    }
}
