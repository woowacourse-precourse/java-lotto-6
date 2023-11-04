package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import domain.RateOfReturn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RateOfReturnTest {
    @DisplayName("수익률이 올바르지 않으면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        long income = 5000;
        long money = 8000;

        RateOfReturn rate = new RateOfReturn(income, money);
        double expectedRate = (double) income / money * 100;
        assertThat(rate.getRate()).isEqualTo(expectedRate);
    }
}
