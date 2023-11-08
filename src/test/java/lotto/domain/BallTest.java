package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallTest {
    @DisplayName("보너스 번호가 1~45 범위를 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> Ball.from(60))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
