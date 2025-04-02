package org.ikigaidigital.domain;

import org.ikigaidigital.interest.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

public class TimeDepositCalculator {
    private static final int INTEREST_LESS_PERIOD_IN_DAYS = 30;

    private final InterestCalculationContext context = new InterestCalculationContext();

    public void updateBalance(List<TimeDeposit> timeDeposits) {
        for (TimeDeposit timeDeposit : timeDeposits) {
            double interest = 0;

            PlanType planType = PlanType.fromString(timeDeposit.getPlanType());

            if (timeDeposit.getDays() > INTEREST_LESS_PERIOD_IN_DAYS) {
                switch (Objects.requireNonNull(planType)) {
                    case BASIC -> context.setStrategy(new BasicInterestStrategy());
                    case STUDENT -> context.setStrategy(new StudentInterestStrategy());
                    case PREMIUM -> context.setStrategy(new PremiumInterestStrategy());
                }

                interest = BigDecimal.valueOf(context.calculateInterest(timeDeposit)).setScale(2, RoundingMode.HALF_UP).doubleValue();
            }

            double totalBalance = timeDeposit.getBalance() + interest;
            timeDeposit.setBalance(totalBalance);
        }
    }
}
