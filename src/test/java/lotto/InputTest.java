package lotto;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static lotto.Error.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputTest {
    private Input input;

    @BeforeEach
    void setUp() {
        input = new Input();
    }

    @DisplayName("아무 입력도 하지않으면 에러가 발생한다.")
    @Test
    void inputByBlank() {
        String inputString = "";
        provideInput(inputString);
        assertThatThrownBy(() -> input.input())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_EMPTY.getErrMsg());
    }

    @DisplayName("입력이 정수가 아니면 에러가 발생한다.")
    @Test
    void inputPurchaseAmountByNotInteger() {
        String inputString = "bad";
        provideInput(inputString);
        assertThatThrownBy(() -> input.inputPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_INTEGER_VALUE.getErrMsg());
    }

    @DisplayName("입력이 1000으로 나누어지지 않으면 에러가 발생한다.")
    @Test
    void inputPurchaseAmountByInvalidValue() {
        String inputString = "11001";
        provideInput(inputString);
        assertThatThrownBy(() -> input.inputPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(UNDIVIDED_PURCHASE_AMOUNT.getErrMsg());
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void inputWinningNumbersByOverSize() {
        String inputString = "1,2,3,4,5,6,7";
        provideInput(inputString);
        assertThatThrownBy(() -> input.inputWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBERS_SIZE.getErrMsg());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void inputWinningNumbersByDuplicatedNumber() {
        String inputString = "1,2,3,4,5,5";
        provideInput(inputString);
        assertThatThrownBy(() -> input.inputWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_NUMBERS.getErrMsg());
    }

    @DisplayName("로또 번호에 46이상의 숫자가있으면 예외가 발생한다.")
    @Test
    void inputWinningNumbersByInvalidedNumber_01() {
        String inputString = "1,2,3,4,5,46";
        provideInput(inputString);
        assertThatThrownBy(() -> input.inputWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBERS_VALUE.getErrMsg());
    }

    @DisplayName("로또 번호에 1이하의 숫자가있으면 예외가 발생한다.")
    @Test
    void inputWinningNumbersByInvalidedNumber_02() {
        String inputString = "-1,2,3,4,5,6";
        provideInput(inputString);
        assertThatThrownBy(() -> input.inputWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBERS_VALUE.getErrMsg());
    }

    @DisplayName("보너스 번호에 정수가 아닌 값이 입력되면 예외가 발생한다.")
    @Test
    void inputBonusNumberByNotInteger() {
        String inputString = "bad";
        provideInput(inputString);
        assertThatThrownBy(() -> input.inputBonusNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_INTEGER_VALUE.getErrMsg());
    }

    @DisplayName("보너스 번호에 46이상의 숫자가있으면 예외가 발생한다.")
    @Test
    void inputBonusNumberByInvalidedNumber_01() {
        String inputString = "46";
        provideInput(inputString);
        assertThatThrownBy(() -> input.inputBonusNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBERS_VALUE.getErrMsg());
    }

    @DisplayName("보너스 번호에 1이하의 숫자가있으면 예외가 발생한다.")
    @Test
    void inputBonusNumberByInvalidedNumber_02() {
        String inputString = "-1";
        provideInput(inputString);
        assertThatThrownBy(() -> input.inputBonusNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBERS_VALUE.getErrMsg());
    }

    @AfterEach
    void 테스트종료() {
        Console.close();
    }

    private void provideInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}