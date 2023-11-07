package lotto.domain;

import static lotto.exception.ExceptionMessage.EMPTY;
import static lotto.exception.ExceptionMessage.NOT_NUMBER;
import static lotto.exception.ExceptionMessage.OUT_OF_RANGE;
import static lotto.exception.ExceptionMessage.DUPLICATED_BONUS_NUMBER;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class WinningNumberTest {
    @DisplayName("[Exception] 입력한 당첨 번호 값이 공백이면 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  ", "\t", "\n"})
    void createWinningNumberByNull(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningNumber.create(input))
                .withMessage(EMPTY.getMessage());
    }

    @DisplayName("[Exception] 숫자가 아닌 값을 입력하면 예외가 발생한다.")
    @Test
    void createBonusNumberByNotNumber() {
        WinningNumber winningNumber = WinningNumber.create("1,2,3,4,5,6");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> winningNumber.createBonusNumber("a"))
                .withMessage(NOT_NUMBER.getMessage());
    }

    @DisplayName("[Exception] 당첨 번호와 중복된 보너스 번호를 입력하면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicatedNumber() {
        WinningNumber winningNumber = WinningNumber.create("1,2,3,4,5,6");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> winningNumber.createBonusNumber("1"))
                .withMessage(DUPLICATED_BONUS_NUMBER.getMessage());
    }

    @DisplayName("[Exception] 보너스 번호에 1~45 이외의 숫자를 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void createBonusNumberByOutRangeNumber(String input) {
        WinningNumber winningNumber = WinningNumber.create("1,2,3,4,5,6");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> winningNumber.createBonusNumber(input))
                .withMessage(OUT_OF_RANGE.getMessage());
    }
}
