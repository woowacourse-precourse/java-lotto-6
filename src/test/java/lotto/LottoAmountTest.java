package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoAmountTest {

    @DisplayName("올바르지 않은 금액 (1000원 미만) 입력 시 예외 발생")
    @Test
    void invalidAmountLessThanLottoPrice() {
        int invalidAmount = 900;
        assertThatThrownBy(() -> new LottoAmount(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 1000원 단위가 아닐 경우 예외 발생")
    @Test
    void invalidAmountNotMultipleOfLottoPrice() {
        int invalidAmount = 1500;
        assertThatThrownBy(() -> new LottoAmount(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 금액으로 로또 구매 가능 장수 계산")
    @Test
    void calculateNumberOfLottos() {
        int amount = 5000;
        LottoAmount lottoAmount = new LottoAmount(amount);
        assertThat(lottoAmount.calculateAmount()).isEqualTo(5);
    }
}
