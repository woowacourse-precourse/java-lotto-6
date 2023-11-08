package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoAmountTest {
    @DisplayName("구입 금액에 숫자 외의 다른 문자가 포함되어 있는 경우 예외가 발생한다.")
    @Test
    void containAnyString() {
        assertThatThrownBy(() -> new LottoAmountValidator("giltae1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void notContainNumber() {
        assertThatThrownBy(() -> new LottoAmountValidator("giltaeyeon"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1,000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void divideBy1000() {
        assertThatThrownBy(() -> new LottoAmountValidator("5555"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
