package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.util.ExceptionEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AmountTest {

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외 처리한다.")
    @ParameterizedTest
    @ValueSource(ints = {100, 10100, 11200, 5100, 10})
    void 구입_금액_단위_예외_처리(int amount) {
        assertThatThrownBy(() -> new Amount(amount)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionEnum.INVALID_PURCHASE_PRICE_UNIT.message());
    }

    @DisplayName("구입 금액이 1000원 단위이다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 10000, 11000, 510000, 11000})
    void 구입_금액_단위(int amount) {
        assertThatNoException().isThrownBy(() -> new Amount(amount));
    }

}