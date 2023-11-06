package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import model.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {
    WinningNumbers winningNumbers;

    @BeforeEach
    void closeConsole() {
        winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("보너스 번호에 1~45의 범위를 넘는 숫자가 있으면 예외가 발생한다.")
    @Test
    void setBonusNumberByNumberOutOfRange() {
        assertThatThrownBy(() -> winningNumbers.setBonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> winningNumbers.setBonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void setBonusNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> winningNumbers.setBonusNumber(5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
