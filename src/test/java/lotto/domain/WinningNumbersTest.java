package lotto.domain;

import lotto.utils.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class WinningNumbersTest {

    @Test
    void 당첨_번호_생성_사이즈_예외처리() {

        List<String[]> inputs = (List<String[]>) List.of(new String[]{""},
                new String[]{"1", "2"}, new String[]{"1", "2", "3", "4", "5"});

        for (String[] input : inputs) {
            errorMessageTest(() -> {
                WinningNumbers.createWinningNumbers(input);
            }, ErrorMessage.WINNING_NUMBER_SIZE);
        }
    }

    @Test
    void 중복_입력_예외처리() {
        errorMessageTest(() -> {
            WinningNumbers.createWinningNumbers(new String[]{"1", "2", "3", "4", "5", "5"});
        }, ErrorMessage.DUPLICATED_WINNING_NUMBERS);
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 11, 12, 13, 14, 15})
    void 당첨_번호_확인_테스트(int number) {
        WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers(new String[]{"10", "11", "12", "13", "14", "15"});
        WinningNumber winningNumber = new WinningNumber(number);

        Assertions.assertThat(winningNumbers.isNumberExist(winningNumber))
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 11, 12, 13, 14, 15})
    void 당첨_번호_미확인_테스트(int number) {
        WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers(new String[]{"1", "2", "3", "4", "5", "6"});
        WinningNumber winningNumber = new WinningNumber(number);

        Assertions.assertThat(winningNumbers.isNumberExist(winningNumber))
                .isFalse();
    }

    private void errorMessageTest(ThrowableAssert.ThrowingCallable executable, ErrorMessage errorMessage) {
        org.assertj.core.api.Assertions.assertThatThrownBy(executable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage.getErrorMessage());
    }
}
