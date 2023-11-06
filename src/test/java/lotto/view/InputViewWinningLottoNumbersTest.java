package lotto.view;

import lotto.view.message.exception.WinningCombinationInputErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputViewWinningLottoNumbersTest {
    private InputView inputView = new InputView();

    void setUp(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @DisplayName("InputWinningNumbers이 정상적인 값이 입력되는 경우 그대로 입력되는지 확인")
    @Test
    void testInputWinningNumbersNumber() {
        String expectedWinningNumbers = "1,2,3,4";
        setUp(expectedWinningNumbers);

        String testResult = inputView.InputWinningNumbers();
        assertThat(testResult)
                .isEqualTo(expectedWinningNumbers);
    }

    @DisplayName("InputWinningNumbers에서 숫자를 넣지 않았을 경우 예외출력 확인")
    @Test
    void testInputWinningNumbersNotNumber(){
        String expectedWinningNumbers = "1,2,3,aaa";
        setUp(expectedWinningNumbers);

        assertThatThrownBy(inputView::InputWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.INCORRECT_FORMET_WINNING_NUMBERS.getMessage());
    }

    @DisplayName("InputWinningNumbers에서 아무것도 입력하지 않았을 때 예외 출력")
    @Test
    void testInputWinningNumbersEmpty() {
        String expectedWinningNumbers = "\n";
        setUp("\n");

        assertThatThrownBy(inputView::InputWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.INCORRECT_FORMET_WINNING_NUMBERS.getMessage());
    }

    @DisplayName("InputWinningNumbers에 소수를 적었을 때 예외 출력")
    @Test
    void testInputWinningNumbersDouble() {
        String expectedWinningNumbers = "10000.11";
        setUp("1000.11");

        assertThatThrownBy(inputView::InputWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.INCORRECT_FORMET_WINNING_NUMBERS.getMessage());
    }
}