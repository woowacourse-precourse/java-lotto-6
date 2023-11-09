package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {

    @Test
    @DisplayName("보너스 번호 중 1~45 사이가 아닌 숫자가 있으면 예외가 발생한다.")
    void createWinningNumberByRange() {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
        assertThatThrownBy(() -> new BonusNumber(winningNumber, "46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호에 문자가 있으면 예외가 발생한다.")
    void createWinningNumberByType() {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
        assertThatThrownBy(() -> new BonusNumber(winningNumber, "ㅏ"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호에 당첨 번호와 같은 번호가 있으가 예외가 발생한다.")
    void createWinningNumberByOverlap() {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
        assertThatThrownBy(() -> new BonusNumber(winningNumber, "6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
