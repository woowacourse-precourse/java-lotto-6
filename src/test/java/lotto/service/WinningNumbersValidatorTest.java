package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersValidatorTest {
    @DisplayName("당첨 번호의 입력값이 없으면 예외가 발생한다.")
    @Test
    void isNothingWinningNumberTest() {
        List<String> input = new ArrayList<>();
        assertThatThrownBy(() -> WinningNumbersValidator.isNothingWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호를 쉼표로 구분해서 6개 입력하지 않으면 예외가 발생한다.")
    @Test
    void isRightFormatTest() {
        List<String> input = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
        assertThatThrownBy(() -> WinningNumbersValidator.isRightFormat(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 쉼표 뒤 공백이나 숫자가 아닌 글자가 포함되어 있으면 예외가 발생한다.")
    @Test
    void isDigitWinningNumberTest() {
        List<String> input = new ArrayList<>(Arrays.asList("1", " 2", "3", "4", "5", "6"));
        assertThatThrownBy(() -> WinningNumbersValidator.isDigitWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 쉼표 사이에 숫자가 없으면 예외가 발생한다.")
    @Test
    void isIncludeEmptyTest() {
        List<String> input = new ArrayList<>(Arrays.asList("1", "", "3", "4", "5", "6"));
        assertThatThrownBy(() -> WinningNumbersValidator.isIncludeEmpty(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 1부터 45 사이의 숫자가 아닌 숫자가 포함되면 예외가 발생한다.")
    @Test
    void isRightNumberTest() {
        List<String> input = new ArrayList<>(Arrays.asList("1", "0", "3", "4", "47", "6"));
        assertThatThrownBy(() -> WinningNumbersValidator.isRightNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 존재하면 예외가 발생한다.")
    @Test
    void isDuplicatedTest() {
        List<String> input = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "2"));
        assertThatThrownBy(() -> WinningNumbersValidator.isDuplicated(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 존재하면 예외가 발생한다.")
    @Test
    void isDuplicatedBonusNumberTest() {
        String input1 = "3";
        List<String> input2 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6"));
        assertThatThrownBy(() -> WinningNumbersValidator.isDuplicatedBonusNumber(input1, input2))
                .isInstanceOf(IllegalArgumentException.class);
    }

}