package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    final static String ERROR_MESSAGE = "[ERROR] ";
    WinningNumber winningNumber = new WinningNumber(List.of(1,2,3,4,5,6));

    @DisplayName("보너스 번호가 1~45 사이의 번호가 아닐 경우 예외가 발생한다.")
    @Test
    public void createOutOfRange() {
        assertThatThrownBy(() -> new BonusNumber(winningNumber, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 일치할 경우 에러 메시지를 출력한다.")
    @Test
    public void createByWinningNumber() {
        assertThatThrownBy(() -> new BonusNumber(winningNumber, 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

}