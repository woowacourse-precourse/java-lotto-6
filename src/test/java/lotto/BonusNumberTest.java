package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {

    @DisplayName("보너스번호가 당첨번호와 중복되는 값이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void bonusNumberDuplicatedWithWinningNumber(int bonusNumberValue) {
        WinningNumber winningNumber = WinningNumber.from(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new BonusNumber(bonusNumberValue, winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호와 중복되지 않는 값이어야 합니다.");
    }

    @DisplayName("보너스번호와 당첨번호에 중복이 없으면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {31, 32, 33, 34, 35, 36})
    void bonusNumberNotDuplicatedWithWinningNumber(int bonusNumberValue) {
        WinningNumber winningNumber = WinningNumber.from(List.of(1, 2, 3, 4, 5, 6));

        assertThatCode(() -> new BonusNumber(bonusNumberValue, winningNumber))
                .doesNotThrowAnyException();
    }
}