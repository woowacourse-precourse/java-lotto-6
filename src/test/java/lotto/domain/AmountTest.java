package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AmountTest {
    @DisplayName("구입 금액이 정수가 아니면 예외가 발생한다.")
    @Test
    void createAmountByNotInteger() {
        assertThatThrownBy(() -> new Amount("1000won"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 소수이면 예외가 발생한다.")
    @Test
    void createAmountByDouble() {
        assertThatThrownBy(() -> new Amount("1000.0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 0이면 예외가 발생한다.")
    @Test
    void createAmountByZero() {
        assertThatThrownBy(() -> new Amount("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 음수이면 예외가 발생한다.")
    @Test
    void createAmountByNegativeInteger() {
        assertThatThrownBy(() -> new Amount("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createAmountByIntegerNotDividedByPrice() {
        assertThatThrownBy(() -> new Amount("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원이면 1개를 발행한다.")
    @Test
    void createAmountBy1000() {
        assertThat(new Amount("1000").getAmount()).isEqualTo(1000);
    }

    @DisplayName("구입 금액이 2000원이면 2개를 발행한다.")
    @Test
    void createAmountBy2000() {
        assertThat(new Amount("2000").getAmount()).isEqualTo(2000);
    }

    @DisplayName("공백이 잘 제거되는지 확인한다.")
    @Test
    void createAmountBy1000withSpaces() {
        assertThat(new Amount("   1000").getAmount()).isEqualTo(1000);
        assertThat(new Amount("1000   ").getAmount()).isEqualTo(1000);
        assertThat(new Amount(" 1000  ").getAmount()).isEqualTo(1000);
    }
}
