package lotto.domain;

import lotto.utils.ErrorMessage;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class WinningNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 47})
    void 당첨번호_생성자_기본예외테스트(int winningNumber) {
        errorMessageTest(() -> {
            new WinningNumber(winningNumber);
        }, ErrorMessage.NON_WINNING_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    void 공백_당첨번호_생성_예외처리(String winningNumber) {
        errorMessageTest(() -> {
            WinningNumber.createWinningNumber(winningNumber);
        }, ErrorMessage.INPUT_IS_EMPTY);
    }

    @ParameterizedTest
    @ValueSource(strings = {"99999999999999999999999", "k4672", "1000j", "1.0"})
    void 당첨번호_정수_아닌경우_예외처리(String winningNumber) {
        errorMessageTest(() -> {
            WinningNumber.createWinningNumber(winningNumber);
        }, ErrorMessage.WINNING_NUMBER_IS_NON_INTEGER_VALUE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "47", "0"})
    void 범위_초과_당첨번호_예외처리(String winningNumber) {
        errorMessageTest(() -> {
            WinningNumber.createWinningNumber(winningNumber);
        }, ErrorMessage.NON_WINNING_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 당첨번호_확인_테스트(int number) {
        WinningNumber winningNumber = new WinningNumber(number);

        winningNumber.isNumberExist(number);
    }

    private void errorMessageTest(ThrowableAssert.ThrowingCallable executable, ErrorMessage errorMessage) {
        org.assertj.core.api.Assertions.assertThatThrownBy(executable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage.getErrorMessage());
    }
}
