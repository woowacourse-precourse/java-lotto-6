package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoPurchaseManagerTest {
    LottoPurchaseManager lottoPurchaseManager = new LottoPurchaseManager(new LottoGenerator());
    String money;

    @DisplayName("구입금액은 1000으로 나눠떨어지지 않으면 예외가 발생한다.")
    @Test
    void cannotPurchaseWithInvalidPurchaseAmount_number() {
        money = "10100";
        assertThatThrownBy(() -> lottoPurchaseManager.createLottos(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 0이면 예외가 발생한다")
    @Test
    void cannotPurchaseWithInvalidPurchaseAmount_zero() {
        money = "0";
        assertThatThrownBy(() -> lottoPurchaseManager.createLottos(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 음수이면 예외가 발생한다")
    @Test
    void cannotPurchaseWithInvalidPurchaseAmount_negativeNumber() {
        money = "-10000";
        assertThatThrownBy(() -> lottoPurchaseManager.createLottos(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 문자열이면 예외가 발생한다.")
    @Test
    void cannotPurchaseWithInvalidPurchaseAmount_string() {
        money = "svgf";
        assertThatThrownBy(() -> lottoPurchaseManager.createLottos(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 공백이면 예외가 발생한다.")
    @Test
    void cannotPurchaseWithInvalidPurchaseAmount_blank() {
        money = " ";
        assertThatThrownBy(() -> lottoPurchaseManager.createLottos(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
