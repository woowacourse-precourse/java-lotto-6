package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCostTest {
    LottoCost lottoCost = new LottoCost();

    @DisplayName("구입금액이 숫자가 아닐 경우 false가 반환된다.")
    @Test
    void costNotNumber() {
        assertThat(lottoCost.isNumber("abc123가나다")).isEqualTo(false);
    }

    @DisplayName("구입금액이 1000의 배수가 아닐 경우 false가 반환된다.")
    @Test
    void costNotMultipleOfThousand() {
        assertThat(lottoCost.isMultipleOfThousand(1375)).isEqualTo(false);
    }
}