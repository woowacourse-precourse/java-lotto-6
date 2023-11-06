package lotto.domain;

import lotto.domian.LottoAmount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class LottoAmountTest {
    @ParameterizedTest
    @ValueSource(ints = {-1,0,1,999})
    @DisplayName("구매 금액을 1,000 미만 입력 시 ")
    void inputLessThan1000(int input) {
        assertThatThrownBy(() -> LottoAmount.validateAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1001, 1350, 2345, 9999})
    @DisplayName("구매 금액이 1,000으로 나누어 떨어지지 않게 입력 시 ")
    void inputIndivisibilityBy1000(int input) {
        assertThatThrownBy(() -> LottoAmount.validateAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
