package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.LottoCost;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCostTest {
    @DisplayName("구입금액이 지정한 1000의 배수가 아닐 경우 예외가 발생한다.")
    @Test
    void costNotMultipleOfUnit() {
        assertThatThrownBy(() -> new LottoCost(1375))
                .isInstanceOf(IllegalArgumentException.class);
    }
}