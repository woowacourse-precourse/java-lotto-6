package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("IncomeRate 객체 테스트")
class IncomeRateTest {

    @DisplayName("getIncomeRate 메소드 테스트")
    @Nested
    class getIncomeRate {

        @DisplayName("비율 계산을 소수점 둘째 자리까지 계산한다.")
        @Test
        void calculateIncomeRate() {
            IncomeRate incomeRate = new IncomeRate(10000, 6);
            Assertions.assertEquals(incomeRate.getPercentageIncomeRate(), 6f / 100);
        }

    }

}