package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.message.exception.WinningCombinationInputErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewWinningLottoNumbersTest {
    private InputView inputView = new InputView();

    void setUp(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @DisplayName("정상적인 값 입력")
    @Test
    void createInputRightWinningNumbersNumber() {
        String expectedWinningNumbers = "1,2,3,4,5,7";
        setUp(expectedWinningNumbers);

        String testResult = inputView.InputWinningNumbers();
        assertThat(testResult)
                .isEqualTo(expectedWinningNumbers);
        Console.close();
    }

    @DisplayName("숫자를 넣지 않았을 때")
    @Test
    void createInputWinningNumbersNotNumber(){
        String expectedWinningNumbers = "1,2,3,aaa";
        setUp(expectedWinningNumbers);

        assertThatThrownBy(inputView::InputWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.INCORRECT_FORMET_WINNING_NUMBERS.getMessage());
        Console.close();
    }

    @DisplayName("아무것도 입력하지 않았을 때")
    @Test
    void createInputWinningNumbersEmpty() {
        String expectedWinningNumbers = "\n";
        setUp(expectedWinningNumbers);

        assertThatThrownBy(inputView::InputWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.INCORRECT_FORMET_WINNING_NUMBERS.getMessage());
        Console.close();
    }

    @DisplayName("소수를 적었을 때")
    @Test
    void createInputWinningNumbersDouble() {
        String expectedWinningNumbers = "10000.11";
        setUp(expectedWinningNumbers);

        assertThatThrownBy(inputView::InputWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.INCORRECT_FORMET_WINNING_NUMBERS.getMessage());
        Console.close();
    }

    @DisplayName("콤마가 맨 앞에 입력되었을 때 예외 발생")
    @Test
    void createWrongSyntexInputWinningNumbers1() {
        String expectedWinningNumbers = ",1,2,3,4,5,6";
        setUp(expectedWinningNumbers);

        assertThatThrownBy(inputView::InputWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.INCORRECT_FORMET_WINNING_NUMBERS.getMessage());
        Console.close();
    }

    @DisplayName("콤마가 맨 뒤에 입력되었을 때 예외 발생")
    @Test
    void createWrongSyntexInputWinningNumbers2() {
        String expectedWinningNumbers = "1,2,3,4,5,6,";
        setUp(expectedWinningNumbers);

        assertThatThrownBy(inputView::InputWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.INCORRECT_FORMET_WINNING_NUMBERS.getMessage());
        Console.close();
    }

    @DisplayName("콤마가 연속으로 입력되었을 때 예외 발생")
    @Test
    void createWrongSyntexInputWinningNumbers3() {
        String expectedWinningNumbers = "1,2,3,,4,5,6,";
        setUp(expectedWinningNumbers);

        assertThatThrownBy(inputView::InputWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.INCORRECT_FORMET_WINNING_NUMBERS.getMessage());
        Console.close();
    }

    @DisplayName("콤마가 연속으로 입력되었을 때(3개 이상) 예외 발생")
    @Test
    void createWrongSyntexInputWinningNumbers4() {
        String expectedWinningNumbers = "1,2,3,,,,,,,4,5,6,";
        setUp(expectedWinningNumbers);

        assertThatThrownBy(inputView::InputWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.INCORRECT_FORMET_WINNING_NUMBERS.getMessage());
        Console.close();
    }
}