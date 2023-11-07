package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputWinningNumTest {
    private static final String BONUS_NUM = "33i";

    @DisplayName("입력 받은 보너스 번호가 숫자가 아니라면 예외가 발생한다.")
    @Test
    void createBonusNumberByNOTInt() {
        assertThatThrownBy(() -> InputWinningNum.inputBonusNumNotInt(BONUS_NUM))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
