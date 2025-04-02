package org.ikigaidigital.interest;

import org.ikigaidigital.domain.TimeDeposit;

public class InterestCalculationContext {
    private InterestCalculationStrategy strategy;

    public void setStrategy(InterestCalculationStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateInterest(TimeDeposit timeDeposit) {
        return strategy.calculateInterest(timeDeposit);
    }
}
