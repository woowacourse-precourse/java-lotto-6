package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoLoverTest {

    @DisplayName("로또 단가로 나누어지지 않는 값을 파라미터로 넘겨준 경우 예외가 발생합니다.")
    @Test
    void passNotDivisibleByLottoPriceToEarnMoneySomehow() {
        assertThatThrownBy(() -> new LottoLover().earnMoneySomehow(2300))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 단가보다 작은 값을 파라미터로 넘겨준 경우 예외가 발생합니다.")
    @Test
    void passLessThanLottoPriceIntegerToEarnMoneySomehow() {
        assertThatThrownBy(() -> new LottoLover().earnMoneySomehow(500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}