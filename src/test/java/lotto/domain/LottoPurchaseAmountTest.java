package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoPurchaseAmountTest {
    @DisplayName("구입금액은 1000으로 나눠떨어지지 않으면 예외가 발생한다.")
    @Test
    void cannotPurchaseWithInvalidPurchaseAmount_number() {
        assertThatThrownBy(() -> LottoPurchaseAmount.create("10100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 0이면 예외가 발생한다")
    @Test
    void cannotPurchaseWithInvalidPurchaseAmount_zero() {
        assertThatThrownBy(() -> LottoPurchaseAmount.create("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 음수이면 예외가 발생한다")
    @Test
    void cannotPurchaseWithInvalidPurchaseAmount_negativeNumber() {
        assertThatThrownBy(() -> LottoPurchaseAmount.create("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 문자열이면 예외가 발생한다.")
    @Test
    void cannotPurchaseWithInvalidPurchaseAmount_string() {
        assertThatThrownBy(() -> LottoPurchaseAmount.create("rsef"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 null이면 예외가 발생한다.")
    @Test
    void cannotPurchaseWithInvalidPurchaseAmount_null() {
        assertThatThrownBy(() -> LottoPurchaseAmount.create(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 공백이면 예외가 발생한다.")
    @Test
    void cannotPurchaseWithInvalidPurchaseAmount_blank() {
        assertThatThrownBy(() -> LottoPurchaseAmount.create(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}