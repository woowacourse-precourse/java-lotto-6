package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class WinningNumbersGeneratorTest {
    private final int LOTTO_NUM_COUNT = 6;

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

}