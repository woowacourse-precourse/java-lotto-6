package lotto.service;

import static lotto.view.InputView.inputMoney;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputServiceTest {
    @Test
    @DisplayName("금액에 따른 구매할 수 있는 로또 장 수")
    void validateCalculateLottoQuantity() {
        // given
        inputMoney = 5000;

        // when
        int result = OutputService.calculateLottoQuantity();

        // then
        assertThat(result).isEqualTo(5);
    }
}
