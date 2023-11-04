package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoPurchaseManagerTest {
    LottoPurchaseManager lottoPurchaseManager = new LottoPurchaseManager();
    long validPurchaseAmount = 10000;
    long invalidPurchaseAmount;
    String invalidPurchaseInput;

    @DisplayName("구입금액은 1000으로 나눠떨어지지 않으면 예외가 발생한다.")
    @Test
    void cannotPurchaseWithInvalidPurchaseAmount_number() {
        invalidPurchaseAmount = 10100;
        assertThatThrownBy(() -> lottoPurchaseManager.calculateLottoQuantity(invalidPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 0이면 예외가 발생한다")
    @Test
    void cannotPurchaseWithInvalidPurchaseAmount_zero() {
        invalidPurchaseAmount = 0;
        assertThatThrownBy(() -> lottoPurchaseManager.calculateLottoQuantity(invalidPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 음수이면 예외가 발생한다")
    @Test
    void cannotPurchaseWithInvalidPurchaseAmount_negativeNumber() {
        invalidPurchaseAmount = -10000;
        assertThatThrownBy(() -> lottoPurchaseManager.calculateLottoQuantity(invalidPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 문자열이면 예외가 발생한다.")
    @Test
    void cannotPurchaseWithInvalidPurchaseAmount_string() {
        invalidPurchaseInput = "svgf";
        assertThatThrownBy(() -> lottoPurchaseManager.calculateLottoQuantity(invalidPurchaseInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 공백이면 예외가 발생한다.")
    @Test
    void cannotPurchaseWithInvalidPurchaseAmount_blank() {
        invalidPurchaseInput = " ";
        assertThatThrownBy(() -> lottoPurchaseManager.calculateLottoQuantity(invalidPurchaseInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액은 1000으로 나눠떨어지면 구입금액에 해당하는 로또를 발행한다.")
    @Test
    void canPurchase() {
        assertThat(lottoPurchaseManager.calculateLottoQuantity(validPurchaseAmount)).isEqualTo(10);  //구입 개수를 리턴
    }
}
