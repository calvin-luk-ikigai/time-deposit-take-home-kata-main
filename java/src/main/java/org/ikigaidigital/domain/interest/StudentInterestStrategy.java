package org.ikigaidigital.domain.interest;

import org.ikigaidigital.domain.TimeDeposit;

public class StudentInterestStrategy implements InterestCalculationStrategy {
    private static final int STUDENT_INTEREST_EFFECTIVE_PERIOD_IN_DAYS = 366;

    @Override
    public double calculateInterest(TimeDeposit timeDeposit) {
        if (timeDeposit.getDays() < STUDENT_INTEREST_EFFECTIVE_PERIOD_IN_DAYS) {
            return timeDeposit.getBalance() * 0.03 / 12;
        }
        return 0;
    }
}
