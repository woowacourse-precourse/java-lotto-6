package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCountTest {
    @DisplayName("로또 구매 금액이 일정 단위로 나누어 떨어지는지 확인한다.")
    @Test
    void buyAmountUnitIncorrect() {
        int input = 16500;
        int unit = 1000;
        assertThatThrownBy(() -> {
            if (input / unit != 0) {
                throw new IllegalArgumentException("1000원 단위로 입력해주세요.");
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
