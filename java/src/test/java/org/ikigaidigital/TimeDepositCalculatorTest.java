package org.ikigaidigital;

import org.ikigaidigital.domain.TimeDeposit;
import org.ikigaidigital.domain.TimeDepositCalculator;
import org.ikigaidigital.domain.interest.PlanType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class TimeDepositCalculatorTest {
    static Stream<Arguments> timeDepositSource() {
        return Stream.of(
                Arguments.of(new TimeDeposit(1, PlanType.BASIC.getValue(), 3000.0, 60), 3002.50),
                Arguments.of(new TimeDeposit(2, PlanType.STUDENT.getValue(), 1000.0, 60), 1002.50),
                Arguments.of(new TimeDeposit(3, PlanType.PREMIUM.getValue(), 2000.0, 60), 2008.33),

                // No interest for the first 30 days for all plans
                Arguments.of(new TimeDeposit(4, PlanType.BASIC.getValue(), 3000.0, 20), 3000.0),
                Arguments.of(new TimeDeposit(5, PlanType.STUDENT.getValue(), 1000.0, 20), 1000.0),
                Arguments.of(new TimeDeposit(6, PlanType.PREMIUM.getValue(), 2000.0, 20), 2000.0),

                // Interest starts after 45 days so no interest less than 46 days for premium plan
                Arguments.of(new TimeDeposit(7, PlanType.PREMIUM.getValue(), 2000.0, 35), 2000.0),
                Arguments.of(new TimeDeposit(8, PlanType.PREMIUM.getValue(), 2000.0, 45), 2000.0),
                Arguments.of(new TimeDeposit(9, PlanType.PREMIUM.getValue(), 2000.0, 46), 2008.33),

                // No interest after 1 year for student plan
                Arguments.of(new TimeDeposit(10, PlanType.STUDENT.getValue(), 1000.0, 367), 1000.0)

        );
    }

    @ParameterizedTest
    @MethodSource("timeDepositSource")
    public void updateBalance_Test(TimeDeposit timeDeposit, Double expectedBalance) {
        TimeDepositCalculator calc = new TimeDepositCalculator();

        calc.updateBalance(List.of(timeDeposit));

        assertThat(timeDeposit.getBalance()).isEqualTo(expectedBalance);
    }
}
