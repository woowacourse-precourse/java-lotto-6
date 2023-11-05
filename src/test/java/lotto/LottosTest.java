package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {
    @DisplayName("1000단위가 아닌 구입금액 들어올 경우 예외를 반환한다.")
    @Test
    void createLottosNotValidPurchasingAmount() {
        assertThatThrownBy(() -> new Lottos("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");

        assertThatThrownBy(() -> new Lottos("0000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }
}
