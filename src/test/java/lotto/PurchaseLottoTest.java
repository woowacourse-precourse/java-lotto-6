package lotto;

import lotto.domain.PurchaseLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseLottoTest {
    @DisplayName("로또 구매 금액에 공백이 포함되면 예외가 발생한다.")
    @Test
    void purchaseLottoBySpace() {
        assertThatThrownBy(() -> new PurchaseLotto("10 00"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액이 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void purchaseLottoByNonNumber() {
        assertThatThrownBy(() -> new PurchaseLotto("1000a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액의 첫 숫자가 0이면 예외가 발생한다.")
    @Test
    void purchaseLottoByLeadingZero() {
        assertThatThrownBy(() -> new PurchaseLotto("01000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void purchaseLottoByNonMultipleOf1000() {
        assertThatThrownBy(() -> new PurchaseLotto("1500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액이 10만원을 초과하면 예외가 발생한다.")
    @Test
    void purchaseLottoByOverMaxAmount() {
        assertThatThrownBy(() -> new PurchaseLotto("110000"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
