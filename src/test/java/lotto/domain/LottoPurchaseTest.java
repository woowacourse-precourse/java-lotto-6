package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPurchaseTest {
    private LottoPurchase lottoPurchase;
    @BeforeEach
    @Test
    void createLottoPurchase() {
        lottoPurchase = new LottoPurchase(5);
        lottoPurchase = new LottoPurchase("5");
    }
    @DisplayName("숫자형이 아닌 문자가 들어오면 예외가 발생한다.")
    @Test
    void createLottoPurchaseAmountByString() {
        assertThatThrownBy(() -> new LottoPurchase("5wqesad")).isInstanceOf(IllegalArgumentException.class);
    }


}