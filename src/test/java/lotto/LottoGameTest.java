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
}
