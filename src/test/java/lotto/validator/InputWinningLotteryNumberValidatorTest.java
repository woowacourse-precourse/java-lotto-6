package lotto.validator;

import lotto.domain.Lotto;
import lotto.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputWinningLotteryNumberValidatorTest {

    private final InputWinningLotteryNumberValidator validator = new InputWinningLotteryNumberValidator();

    @DisplayName("당첨 번호가 공백일 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "   "})
    void validateWinningLotteryNumbersIsBlank(String input) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> validator.validate(input));
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.INPUT_DOES_NOT_BLANK.getMessage());
    }

    @DisplayName("당첨 번호가 정수가 아닐 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"ㅁㄱㅂ1", "asd1", "3ss"})
    void validateWinningLotteryNumbersIsNumeric(String input) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> validator.validate(input));
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.INPUT_MUST_BE_NUMERIC.getMessage());
    }

    @DisplayName("당첨 번호가 양수가 아닐 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2", "-30"})
    void validateWinningLotteryNumbersIsPositive(String input) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> validator.validate(input));
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.INPUT_MUST_BE_POSITIVE.getMessage());
    }

    @DisplayName("당첨 번호가 로또 숫자 범위를 벗어나는 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"50", "46"})
    void validateWinningLotteryNumbersIsBetweenValidRange(String input) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> validator.validate(input));
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외 발생")
    @Test
    void validateWinningLotteryNumbersSize() {
        List<Integer> winningLotteryNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateSizeAndDuplicatedNumbers(winningLotteryNumbers)
        );
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.SIZE_OF_LOTTO_NUMBERS_LIST_MUST_BE_6.getMessage());
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외 발생")
    @Test
    void validateWinningLotteryNumbersIsDuplicated() {
        List<Integer> winningLotteryNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 5));

        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateSizeAndDuplicatedNumbers(winningLotteryNumbers)
        );
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.LOTTO_NUMBERS_CANNOT_BE_DUPLICATED.getMessage());
    }
}