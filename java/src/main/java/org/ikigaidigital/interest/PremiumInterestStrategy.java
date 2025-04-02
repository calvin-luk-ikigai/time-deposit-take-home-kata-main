package org.ikigaidigital.interest;

import org.ikigaidigital.domain.TimeDeposit;

public class PremiumInterestStrategy implements InterestCalculationStrategy {
    private static final int PREMIUM_INTEREST_LESS_PERIOD_IN_DAYS = 45;

    @Override
    public double calculateInterest(TimeDeposit timeDeposit) {
        if (timeDeposit.getDays() > PREMIUM_INTEREST_LESS_PERIOD_IN_DAYS) {
            return timeDeposit.getBalance() * 0.05 / 12;
        }
        return 0;
    }
}
