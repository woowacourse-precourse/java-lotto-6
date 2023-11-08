package lotto.checker;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersCheckerTest {

    @DisplayName("당첨 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void getWinningNumbersByOverSize() {
        assertThatThrownBy(() -> WinningNumbersChecker.rightSize(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.REQUIRE_SIX_NUMBERS.getMessage());
    }

    @DisplayName("당첨 번호에 1~45 이외의 숫자가 있으면 예외가 발생한다.")
    @Test
    void getWinningNumbersByOutOfRangeNumber_1() {
        assertThatThrownBy(() -> WinningNumbersChecker.rightNumbers(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.REQUIRE_RIGHT_RANGE_NUMBER.getMessage());
    }

    @DisplayName("당첨 번호에 1~45 이외의 숫자가 있으면 예외가 발생한다.")
    @Test
    void getWinningNumbersByOutOfRangeNumber_2() {
        assertThatThrownBy(() -> WinningNumbersChecker.rightNumbers(List.of(-1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.REQUIRE_RIGHT_RANGE_NUMBER.getMessage());
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void getWinningNumbersByDuplicatedNumber() {
        assertThatThrownBy(() -> WinningNumbersChecker.rightNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.REQUIRE_UNIQUE_NUMBERS.getMessage());
    }
}
