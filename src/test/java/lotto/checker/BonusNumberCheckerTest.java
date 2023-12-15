package lotto.checker;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberCheckerTest {

    @DisplayName("보너스 번호가 1~45 이외의 숫자면 예외가 발생한다.")
    @Test
    void getBonusNumberByOutOfRangeNumber_1() {
        assertThatThrownBy(() -> BonusNumberChecker.rightRange(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.REQUIRE_RIGHT_RANGE_NUMBER.getMessage());
    }

    @DisplayName("보너스 번호가 1~45 이외의 숫자면 예외가 발생한다.")
    @Test
    void getBonusNumberByOutOfRangeNumber_2() {
        assertThatThrownBy(() -> BonusNumberChecker.rightRange(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.REQUIRE_RIGHT_RANGE_NUMBER.getMessage());
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void getBonusNumberDifferentFromWinningNumbers() {
        assertThatThrownBy(() -> BonusNumberChecker.differentFrom(1, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.REQUIRE_DIFFERENT_NUMBER_WITH_WINNING_NUMBERS.getMessage());
    }
}
