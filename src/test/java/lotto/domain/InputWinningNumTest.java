package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputWinningNumTest {
    private static final String BONUS_NUM = "33i";
    private static final int BONUS_NUM_RANGE_OVER = 666;

    @DisplayName("입력 받은 보너스 번호가 숫자가 아니라면 예외가 발생한다.")
    @Test
    void createBonusNumberByNOTInt() {
        assertThatThrownBy(() -> InputWinningNum.inputBonusNumNotInt(BONUS_NUM))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 받은 보너스 번호가 1 ~ 45 사이에 없다면 예외가 발생한다.")
    @Test
    void createBonusNumberByRangeOfNumber() {
        assertThatThrownBy(() -> InputWinningNum.inputBonusNumNotRange(BONUS_NUM_RANGE_OVER))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
