package lotto.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumbersValidationTest {
    private WinningNumbersValidation winningNumbersValidation;

    @BeforeEach
    void setUp() {
        winningNumbersValidation = new WinningNumbersValidation();
    }

    @DisplayName("쉼표(,)를 사용하여 구분하지 않으면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5.6", "1/2/3/4/5,6", "1?2,3,4,5,6"})
    void useIncorrectSeparator(String input) {
        assertThatThrownBy(() -> winningNumbersValidation.validateInputUseCorrectSeparator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 숫자가 아니라면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1a,2,3,4,5,6", "일,이,삼,사,오,육", "a,b,c,d,e,f"})
    void enterWinningNumbersNotNumeric(String input) {
        assertThatThrownBy(() -> winningNumbersValidation.validateWinnerNumbersNumeric(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 음수라면 에러가 발생한다.")
    @Test
    void enterNegativeWinningNumbers() {
        assertThatThrownBy(() -> winningNumbersValidation.validateWinnerNumbersPositive("-1,-2,3,4,5,-6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 int의 범위를 벗어나면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"2200000000,1,2,3,4,5", "-3000000000,6,7,8,9,10"})
    void enterWinningNumbersOutOfRange(String input) {
        String[] winningNumbers = input.split(",");
        assertThatThrownBy(() -> winningNumbersValidation.validateCheckRangeOfWinnerNumberInput(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1부터 45사이의 숫자가 아니라면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,46", "0,1,2,3,4,5"})
    void enterWinningNumbersOutOfRange1to45(String input) {
        List<Integer> winningNumbers = Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());

        assertThatThrownBy(() -> winningNumbersValidation.validateWinnerNumbersOutOfRange(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복되는 당첨 번호가 있다면 에러가 발생한다.")
    @Test
    void enterDuplicateWinningNumbers() {
        List<Integer> winningNumbers = Arrays.asList(1, 1, 2, 3, 4, 5);
        assertThatThrownBy(() -> winningNumbersValidation.validateDuplicateWinnerNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호를 입력하면 List를 반환한다")
    @Test
    void generateWinningNumbersList() {
        List<Integer> result = winningNumbersValidation.validateWinnerNumbers(("1,2,3,4,5,6"));
        assertThat(result).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }
}