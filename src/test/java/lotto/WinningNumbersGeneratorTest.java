package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class WinningNumbersGeneratorTest {


    @DisplayName("당첨 번호의 갯수가 6미만일 경우 예외 처리")
    @Test
    void winningNumbersLengthLessThanSize() {
        //given
        WinningNumbersGenerator winningNumbersGenerator = new WinningNumbersGenerator();

        //when
        String[] winningNumbersInput = {"1", "2", "3", "4", "5"};
        winningNumbersGenerator.setWinningNumberInput(winningNumbersInput);

        //then
        assertThatThrownBy(winningNumbersGenerator::validateEachWinningNumberInput)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 6개의 번호가 필요합니다.")
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("당첨 번호의 갯수가 6초과일 경우 예외 처리")
    @Test
    void winningWinningNumbersLengthOverThanSize() {
        //given
        WinningNumbersGenerator winningNumbersGenerator = new WinningNumbersGenerator();

        //when
        String[] winningNumbersInput = {"1", "2", "3", "4", "5", "6", "7"};
        winningNumbersGenerator.setWinningNumberInput(winningNumbersInput);

        //then
        assertThatThrownBy(winningNumbersGenerator::validateEachWinningNumberInput)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 6개의 번호가 필요합니다.")
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("당첨 번호에 중복된 값이 존재할 경우 예외 처리")
    @Test
    void duplicatedNumberInWinningNumbers() {
        //given
        WinningNumbersGenerator winningNumbersGenerator = new WinningNumbersGenerator();

        //when
        String[] winningNumbersInput = {"1", "2", "3", "4", "5", "5"};
        winningNumbersGenerator.setWinningNumberInput(winningNumbersInput);

        //then
        assertThatThrownBy(winningNumbersGenerator::validateEachWinningNumberInput)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 번호가 있습니다.")
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("당첨 번호가 숫자가 아닌 경우 예외 처리")
    @Test
    void winningNumberNotDigit() {
        //given
        WinningNumbersGenerator winningNumbersGenerator = new WinningNumbersGenerator();

        //when
        String[] winningNumbersInput = {"1", "2", "3", "4", "5", "a"};
        winningNumbersGenerator.setWinningNumberInput(winningNumbersInput);

        //then
        assertThatThrownBy(winningNumbersGenerator::validateDividedInput)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 숫자여야 합니다.")
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("당첨 번호가 범위를 초과한 경우 예외 처리")
    @Test
    void winningNumberOverRange() {
        //given
        WinningNumbersGenerator winningNumbersGenerator = new WinningNumbersGenerator();

        //when
        String[] winningNumbersInput = {"1", "2", "3", "4", "5", "46"};
        winningNumbersGenerator.setWinningNumberInput(winningNumbersInput);

        //then
        assertThatThrownBy(winningNumbersGenerator::validateDividedInput)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 번호는 1부터 45사이의 숫자여야 합니다.")
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("당첨 번호가 범위에 미달일 경우 예외 처리")
    @Test
    void winningNumberLessRange() {
        //given
        WinningNumbersGenerator winningNumbersGenerator = new WinningNumbersGenerator();

        //when
        String[] winningNumbersInput = {"0", "1", "2", "3", "4", "5"};
        winningNumbersGenerator.setWinningNumberInput(winningNumbersInput);

        //then
        assertThatThrownBy(winningNumbersGenerator::validateDividedInput)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 번호는 1부터 45사이의 숫자여야 합니다.")
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("당첨 번호 생성 후 저장")
    @Test
    void generateWinningNumber() {
        //given
        WinningNumbersGenerator winningNumbersGenerator = new WinningNumbersGenerator();

        //when
        String[] numbers = {"1", "2", "6", "7", "43", "21"};
        winningNumbersGenerator.generateWinningNumbers(numbers);
        List<Integer> expectedWinningNumbers = List.of(1, 2, 6, 7, 43, 21);

        //then
        List<Integer> winningNumbers = winningNumbersGenerator.getWinningNumbers();
        assertThat(winningNumbers.size()).isEqualTo(6);
        assertThat(winningNumbers).containsAnyElementsOf(expectedWinningNumbers);
    }

    @DisplayName("보너스 번호가 범위를 초과할 경우 예외 처리")
    @Test
    void bonusNumberOverRange() {
        //given
        WinningNumbersGenerator winningNumbersGenerator = new WinningNumbersGenerator();

        //when
        String[] numbers = {"1", "2", "6", "7", "43", "21"};
        winningNumbersGenerator.generateWinningNumbers(numbers);

        int bonusNumberInput = 46;
        winningNumbersGenerator.saveBonusNumber(bonusNumberInput);

        //then
        assertThatThrownBy(winningNumbersGenerator::validateBonusNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 번호는 1부터 45사이의 숫자여야 합니다.")
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("보너스 번호가 범위 미달일 경우 예외 처리")
    @Test
    void bonusNumberLessRange() {
        //given
        WinningNumbersGenerator winningNumbersGenerator = new WinningNumbersGenerator();

        //when
        String[] numbers = {"1", "2", "6", "7", "43", "21"};
        winningNumbersGenerator.generateWinningNumbers(numbers);

        int bonusNumberInput = 0;

        winningNumbersGenerator.saveBonusNumber(bonusNumberInput);

        //then
        assertThatThrownBy(winningNumbersGenerator::validateBonusNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("보너스 번호가 당첨 번호에 존재할 경우 예외 처리")
    @Test
    void winningNumbersContainBonusNumber() {
        //given
        WinningNumbersGenerator winningNumbersGenerator = new WinningNumbersGenerator();

        //when
        String[] numbers = {"1", "2", "6", "7", "43", "21"};
        winningNumbersGenerator.generateWinningNumbers(numbers);

        int bonusNumberInput = 43;

        winningNumbersGenerator.saveBonusNumber(bonusNumberInput);

        //then
        assertThatThrownBy(winningNumbersGenerator::validateBonusNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호 중 보너스 번호가 존재합니다.")
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("보너스 번호 생성 후 저장")
    @Test
    void generateBonusNumber() {
        //given
        WinningNumbersGenerator winningNumbersGenerator = new WinningNumbersGenerator();

        //when
        String[] numbers = {"1", "2", "6", "7", "43", "21"};
        winningNumbersGenerator.generateWinningNumbers(numbers);

        int bonusNumber = 45;
        winningNumbersGenerator.generateBonusNumber(bonusNumber);

        //then
        assertThat(winningNumbersGenerator.getBonusNumber()).isEqualTo(bonusNumber);
    }
}