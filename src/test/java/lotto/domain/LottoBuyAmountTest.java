package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBuyAmountTest {
    private static final String INVALID_PRICE_RANGE_MESSAGE = "[ERROR] 최소금액은 1,000원입니다.";
    private static final String INVALID_PRICE_MESSAGE = "[ERROR] 로또 구입금액은 1,000원 단위여야합니다.";
    @Test
    @DisplayName("1000원_미만_입력시_예외처리")
    void TEST_1000원_미만_입력시_예외처리() {
        assertThatThrownBy(() -> LottoBuyAmount.getAmount(500))
                .isInstanceOf(IllegalArgumentException.class);

        Throwable exception = assertThrows(RuntimeException.class, () -> {
            LottoBuyAmount.getAmount(500);
        });
        assertThat(exception.getMessage()).isEqualTo(INVALID_PRICE_RANGE_MESSAGE);
    }

    @Test
    @DisplayName("1000원_단위_외_입력시_예외처리")
    void TEST_1000원_단위_외_입력시_예외처리() {
        assertThatThrownBy(() -> LottoBuyAmount.getAmount(1100))
                .isInstanceOf(IllegalArgumentException.class);

        Throwable exception = assertThrows(RuntimeException.class, () -> {
            LottoBuyAmount.getAmount(1100);
        });
        assertThat(exception.getMessage()).isEqualTo(INVALID_PRICE_MESSAGE);
    }
}