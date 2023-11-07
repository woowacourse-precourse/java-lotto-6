package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberValidatorTest {

    @Test
    @DisplayName("당첨 번호에 쉼표가 포함할 경우 예외를 발생시키지 않는다.")
    void notThrowExceptionWinningNumbersContainLestDelimiter() {
        //given
        String winningNumbers = "1,2,3,4,5,6";
        //when //then
        assertThatCode(() -> WinningNumberValidator.validateWinningNumbers(winningNumbers))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("당첨 번호에 쉼표가 포함되지 않을 경우 예외를 발생시킨다.")
    void throwExceptionWinningNumbersNotContainLestDelimiter() {
        //given
        String winningNumbers = "1";
        //when //then
        assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumbers(winningNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 당첨 번호는 쉼표를 구분으로 입력해야 합니다.");
    }
}