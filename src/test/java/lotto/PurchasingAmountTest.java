package lotto;

import lotto.model.Lotto;
import lotto.model.LottoPurchasingAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchasingAmountTest {
    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다")
    @Test
    void createLottoPurchasingAmountByString() {
        assertThatThrownBy(() -> new LottoPurchasingAmount("Test"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원 미만이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1000", "100", "999"})
    void createLottoPurchasingAmountWithLowPrice(String lowPrice) {
        assertThatThrownBy(() -> new LottoPurchasingAmount(lowPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"10001, 9999, 9500"})
    void createLottoPurchasingAmountByInvalidPrice(String invalidPrice) {
        assertThatThrownBy(() -> new LottoPurchasingAmount(invalidPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적인 구입 금액 입력 테스트")
    @Test
    void createLottoPurchasingAmountTest() {
        LottoPurchasingAmount lottoPurchasingAmount = new LottoPurchasingAmount("1000");
        assertThat(lottoPurchasingAmount.getMoney()).isEqualTo(1000);
    }
}