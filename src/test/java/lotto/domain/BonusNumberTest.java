package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    private static final String WINNING_NUMBER = "1,2,3,4,5,6";
    @DisplayName("보너스 번호가 자연수가 아니라면 예외가 발생한다.")
    @Test
    void createBonusNumberByNotNatural() {
        WinningNumber winningNumber = new WinningNumber(WINNING_NUMBER);
        String input = "-1";

        assertThatThrownBy(() -> new BonusNumber(winningNumber, input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
