package org.ikigaidigital.domain.interest;

import org.ikigaidigital.domain.TimeDeposit;

public interface InterestCalculationStrategy {
    double calculateInterest(TimeDeposit timeDeposit);
}
