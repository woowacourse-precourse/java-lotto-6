package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGameTest {
    @DisplayName("입력 값이 숫자가 아니면 예외가 발생한다")
    @Test
    void createNotDigit() {
        assertThatThrownBy(() -> new LottoGame().validateNumber("12e"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자만 입력하세요");
    }

    @DisplayName("입력 값이 1000으로 나누어지는 값인지 확인한다")
    @Test
    void checkMultipleOfThousand() {
        assertThatThrownBy(() -> new LottoGame().validateMultiple("12200"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 한장이 1000원이므로 구매금액은 1000원 단위로 입력해야 합니다.");
    }
}
