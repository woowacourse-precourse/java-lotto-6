package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCostTest {
    @DisplayName("금액의 입력 값이 1000원 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void createLottoCostByRemainder() {
        assertThatThrownBy(() -> new LottoCost(5005))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액의 입력 값이 0원일 경우에 예외가 발생한다.")
    @Test
    void createLottoCostByZero() {
        assertThatThrownBy(() -> new LottoCost(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

}