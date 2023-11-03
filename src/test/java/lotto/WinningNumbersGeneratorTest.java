package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class WinningNumbersGeneratorTest {
    private final int LOTTO_NUM_COUNT = 6;

    @DisplayName("당첨 번호 \',\'으로 나누기")
    @Test
    void dividedByDelimiter() {
        //given
        WinningNumbersGenerator winningNumbersGenerator = new WinningNumbersGenerator();

        //when
        String winningNumbersInput = "1,2,3,4,5,6";
        String [] expectedWinningNumbers = {"1", "2", "3", "4", "5", "6"};
        winningNumbersGenerator.dividedInputByDelimiter(winningNumbersInput);

        //then
        assertThat(winningNumbersGenerator.getInputDividedByDelimiter()).isEqualTo(expectedWinningNumbers);
        assertThat(winningNumbersGenerator.getInputDividedByDelimiter().length).
                isEqualTo(expectedWinningNumbers.length);
    }

    @DisplayName("당첨 번호의 갯수가 6미만일 경우 예외 처리")
    @Test
    void winningNumbersLengthLessThanSize() {
        //given
        WinningNumbersGenerator winningNumbersGenerator = new WinningNumbersGenerator();

        //when
        String winningNumbersInput = "1,2,3,4,5";
        winningNumbersGenerator.dividedInputByDelimiter(winningNumbersInput);

        //then
        assertThatThrownBy(() -> winningNumbersGenerator.validateInputDividedByDelimiter())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 6개의 번호가 필요합니다.");
    }

    @DisplayName("당첨 번호의 갯수가 6초과일 경우 예외 처리")
    @Test
    void winningWinningNumbersLengthOverThanSize() {
        //given
        WinningNumbersGenerator winningNumbersGenerator = new WinningNumbersGenerator();

        //when
        String winningNumbersInput = "1,2,3,4,5,6,7";
        winningNumbersGenerator.dividedInputByDelimiter(winningNumbersInput);

        //then
        assertThatThrownBy(() -> winningNumbersGenerator.validateInputDividedByDelimiter())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 6개의 번호가 필요합니다.");
    }

    @DisplayName("당첨 번호에 중복된 값이 존재할 경우 예외 처리")
    @Test
    void duplicatedNumberInWinningNumbers() {
        //given
        WinningNumbersGenerator winningNumbersGenerator = new WinningNumbersGenerator();

        //when
        String winningNumbersInput = "1,2,3,4,5,5";
        winningNumbersGenerator.dividedInputByDelimiter(winningNumbersInput);

        //then
        assertThatThrownBy(() -> winningNumbersGenerator.validateInputDividedByDelimiter())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 번호가 있습니다.");
    }

    @DisplayName("당첨 번호가 숫자가 아닌 경우 예외 처리")
    @Test
    void winningNumberNotDigit() {
        //given
        WinningNumbersGenerator winningNumbersGenerator = new WinningNumbersGenerator();

        //when
        String winningNumbersInput = "1,a,2,3,4,5";
        winningNumbersGenerator.dividedInputByDelimiter(winningNumbersInput);

        //then
        assertThatThrownBy(() -> winningNumbersGenerator.validateDividedInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 숫자여야 합니다.");
    }

    @DisplayName("당첨 번호가 범위를 초과한 경우 예외 처리")
    @Test
    void winningNumberOverRange() {
        //given
        WinningNumbersGenerator winningNumbersGenerator = new WinningNumbersGenerator();

        //when
        String winningNumbersInput = "46";
        winningNumbersGenerator.dividedInputByDelimiter(winningNumbersInput);
        //then
        assertThatThrownBy(() -> winningNumbersGenerator.validateDividedInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 번호는 1부터 45사이의 숫자여야 합니다.");
    }

    @DisplayName("당첨 번호가 범위에 미달일 경우 예외 처리")
    @Test
    void winningNumberLessRange() {
        //given
        WinningNumbersGenerator winningNumbersGenerator = new WinningNumbersGenerator();

        //when
        String winningNumbersInput = "0";
        winningNumbersGenerator.dividedInputByDelimiter(winningNumbersInput);
        //then
        assertThatThrownBy(() -> winningNumbersGenerator.validateDividedInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 번호는 1부터 45사이의 숫자여야 합니다.");
    }

    @DisplayName("당첨 번호 생성 후 저장")
    @Test
    void generateWinningNumber() {
        //given
        WinningNumbersGenerator winningNumbersGenerator = new WinningNumbersGenerator();

        //when
        String numbers = "1,2,6,7,43,21";
        winningNumbersGenerator.generateWinningNumbers(numbers);
        List<Integer> expectedWinningNumbers = List.of(1, 2, 6, 7, 43, 21);

        //then
        List<Integer> winningNumbers = winningNumbersGenerator.getWinningNumbers();
        assertThat(winningNumbers.size()).isEqualTo(6);
        assertThat(winningNumbers).containsAnyElementsOf(expectedWinningNumbers);
    }
}