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

    @DisplayName("정상적인 값 입력")
    @Test
    void testInputWinningNumbersNumber() {
        String expectedWinningNumbers = "1,2,3,4,5,7";
        setUp(expectedWinningNumbers);

        String testResult = inputView.InputWinningNumbers();
        assertThat(testResult)
                .isEqualTo(expectedWinningNumbers);
    }

    @DisplayName("숫자를 넣지 않았을 때")
    @Test
    void testInputWinningNumbersNotNumber(){
        String expectedWinningNumbers = "1,2,3,aaa";
        setUp(expectedWinningNumbers);

        assertThatThrownBy(inputView::InputWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.INCORRECT_FORMET_WINNING_NUMBERS.getMessage());
    }

    @DisplayName("아무것도 입력하지 않았을 때")
    @Test
    void testInputWinningNumbersEmpty() {
        String expectedWinningNumbers = "\n";
        setUp("\n");

        assertThatThrownBy(inputView::InputWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.INCORRECT_FORMET_WINNING_NUMBERS.getMessage());
    }

    @DisplayName("소수를 적었을 때")
    @Test
    void testInputWinningNumbersDouble() {
        String expectedWinningNumbers = "10000.11";
        setUp(expectedWinningNumbers);

        assertThatThrownBy(inputView::InputWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.INCORRECT_FORMET_WINNING_NUMBERS.getMessage());
    }

    @DisplayName("콤마 입력 형식이 잘못되었을 때")
    @Test
    void wrongSyntexInputWinningNumbers1() {
        String expectedWinningNumbers = ",1,2,3,4,5,6";
        setUp(expectedWinningNumbers);

        assertThatThrownBy(inputView::InputWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.INCORRECT_FORMET_WINNING_NUMBERS.getMessage());
    }

    @DisplayName("콤마 입력 형식이 잘못되었을 때")
    @Test
    void wrongSyntexInputWinningNumbers2() {
        String expectedWinningNumbers = "1,2,3,4,5,6,";
        setUp(expectedWinningNumbers);

        assertThatThrownBy(inputView::InputWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.INCORRECT_FORMET_WINNING_NUMBERS.getMessage());
    }

    @DisplayName("콤마 입력 형식이 잘못되었을 때")
    @Test
    void wrongSyntexInputWinningNumbers3() {
        String expectedWinningNumbers = "1,2,3,,4,5,6,";
        setUp(expectedWinningNumbers);

        assertThatThrownBy(inputView::InputWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.INCORRECT_FORMET_WINNING_NUMBERS.getMessage());
    }

    @DisplayName("콤마 입력 형식이 잘못되었을 때")
    @Test
    void wrongSyntexInputWinningNumbers4() {
        String expectedWinningNumbers = "1,2,3,,,,,,,4,5,6,";
        setUp(expectedWinningNumbers);

        assertThatThrownBy(inputView::InputWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.INCORRECT_FORMET_WINNING_NUMBERS.getMessage());
    }
}