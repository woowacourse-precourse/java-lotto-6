package lotto;

import lotto.domain.PurchaseLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseLottoTest {
    @DisplayName("로또 구매 금액에 공백이 포함되면 예외가 발생한다.")
    @Test
    void purchaseLottoBySpace() {
        String purchaseAmount = "10 00";
        assertThatThrownBy(() -> PurchaseLotto.validator(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액이 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void purchaseLottoByNonNumber() {
        String purchaseAmount = "1000a";
        assertThatThrownBy(() -> PurchaseLotto.validator(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액의 첫 숫자가 0이면 예외가 발생한다.")
    @Test
    void purchaseLottoByLeadingZero() {
        String purchaseAmount = "01000";
        assertThatThrownBy(() -> PurchaseLotto.validator(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void purchaseLottoByNonMultipleOf1000() {
        String purchaseAmount = "1500";
        assertThatThrownBy(() -> PurchaseLotto.validator(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액이 10만원을 초과하면 예외가 발생한다.")
    @Test
    void purchaseLottoByOverMaxAmount() {
        String purchaseAmount = "110000";
        assertThatThrownBy(() -> PurchaseLotto.validator(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
