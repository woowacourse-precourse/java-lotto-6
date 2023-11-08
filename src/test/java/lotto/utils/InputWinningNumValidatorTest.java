package lotto.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constants.ExceptionMessage;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.Test;

class InputWinningNumValidatorTest {

    @Test
    void 쉼표로_시작하는_경우() {
        // given
        String winningNumbers = ",1,2,3,4,5,6";

        assertThatThrownBy(() -> InputValidator.validateWinningNumber(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DELIM_START_END_ERROR.getMessage());
    }

    @Test
    void 공백이_포함된_경우() {
        // given
        String winningNumbers = "1, 2 , 3 , 4,5,6";

        assertThatThrownBy(() -> InputValidator.validateWinningNumber(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WHITESPACE_ERROR.getMessage());
    }

    @Test
    void split후_문자가_포함된_경우() {
        // given
        String winningNumbers = "1,2,3,4,5,a";

        assertThatThrownBy(() -> InputValidator.validateWinningNumber(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_INTEGER_ERROR.getMessage());
    }

    @Test
    void split후_45_보다_큰_경우() {
        // given
        String winningNumbers = "1,234,345,4,5,6";

        assertThatThrownBy(() -> InputValidator.validateWinningNumber(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.LOTTO_RANGE_ERROR.getMessage());
    }

    @Test
    void split후_1_보다_작은_경우() {
        // given
        String winningNumbers = "1,-2,0,3,4,5";

        assertThatThrownBy(() -> InputValidator.validateWinningNumber(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.LOTTO_RANGE_ERROR.getMessage());
    }

    @Test
    void 로또번호_6개_아닌_경우() {
        String winningNumbers = "1,2,3,4,5";
        assertThatThrownBy(() -> WinningNumber.consistOf(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.LOTTO_LENGTH_ERROR.getMessage());
    }

    @Test
    void 로또번호_중복된_경우() {
        String winningNumbers = "1,2,2,4,5,6";
        assertThatThrownBy(() -> WinningNumber.consistOf(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.LOTTO_DUPLICATE_ERROR.getMessage());
    }


}