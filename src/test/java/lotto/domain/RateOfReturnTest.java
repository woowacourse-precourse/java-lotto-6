package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.RateOfReturn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RateOfReturnTest {
    @DisplayName("수익률 계산 정확성 테스트")
    @Test
    void createRateOfReturn() {
        // 일반적인 수익률 계산
        long income = 5000;
        long money = 8000;

        RateOfReturn rate = new RateOfReturn(income, money);
        double expectedRate = (double) income / money * 100;
        assertThat(rate.getRate()).isEqualTo(expectedRate);

        // 수익이 0인 경우 계산
        income = 0;

        RateOfReturn zeroIncomeRate = new RateOfReturn(income, money);
        expectedRate = (double) income / money * 100;
        assertThat(zeroIncomeRate.getRate()).isEqualTo(expectedRate);
    }
}
