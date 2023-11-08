package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {

    @DisplayName("가격이 1000으로 나누어떨어지지 않는다면 예외가 발생한다.")
    @Test
    void createLottosWithNotDividedBy1000() {
        assertThatThrownBy(() -> new Lottos(1222))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("가격이 1000으로 나누어떨어지면 예외가 발생하지 않는다.")
    @Test
    void createLottosWithDividedBy1000() {
        Assertions.assertThatNoException().isThrownBy(() -> new Lottos(10000));
    }

}