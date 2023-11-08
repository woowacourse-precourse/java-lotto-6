package lotto.domain;


import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import lotto.constant.ExceptionMessage;
import lotto.util.NumberConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    private WinningNumbers winningNumbers;

    @BeforeEach
    void setUp() {
        winningNumbers = new WinningNumbers(new NumberConverter());
    }


    @DisplayName("유효한 번호 문자열을 올바르게 처리해야 한다.")
    @Test
    void testProcessWithValidNumbers() {
        // given
        String numbers = "1, 2, 3, 4, 5, 6";

        // when
        List<Integer> result = winningNumbers.process(numbers);

        // then
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }


    @DisplayName("쉼표로 시작하는 경우 IllegalArgumentException을 발생시켜야 한다.")
    @Test
    void testProcessWithLeadingComma() {
        // given
        String numbersWithLeadingComma = ",1, 2, 3, 4, 5, 6";

        // when & then
        assertThatThrownBy(() -> winningNumbers.process(numbersWithLeadingComma))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_COMMA_USAGE.getMessage());
    }


    @DisplayName("쉼표로 끝나는 경우 IllegalArgumentException을 발생시켜야 한다.")
    @Test
    void testProcessWithTrailingComma() {
        // given
        String numbersWithTrailingComma = "1, 2, 3, 4, 5, 6,";

        // when & then
        assertThatThrownBy(() -> winningNumbers.process(numbersWithTrailingComma))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_COMMA_USAGE.getMessage());
    }


    @DisplayName("연속된 쉼표가 있는 경우 IllegalArgumentException을 발생시켜야 한다.")
    @Test
    void testProcessWithConsecutiveCommas() {
        // given
        String numbersWithConsecutiveCommas = "1,, 2, 3, 4, 5, 6";

        // when & then
        assertThatThrownBy(() -> winningNumbers.process(numbersWithConsecutiveCommas))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_COMMA_USAGE.getMessage());
    }

    @DisplayName("공백 문자가 포함된 번호 문자열도 올바르게 처리해야 한다.")
    @Test
    void testProcessWithSpaces() {
        // given
        String numbersWithSpaces = " 1 , 2 , 3 , 4 , 5 , 6 ";

        // when
        List<Integer> result = winningNumbers.process(numbersWithSpaces);

        // then
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }


    @DisplayName("숫자가 아닌 문자열이 포함되어 있을 경우 IllegalArgumentException을 발생시켜야 한다.")
    @Test
    void testProcessWithNonNumericValues() {
        // given
        String numbersWithNonNumeric = "1, 2, three, 4, 5, 6";

        // when & then
        assertThatThrownBy(() -> winningNumbers.process(numbersWithNonNumeric))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_NUMBER.getMessage());
    }

    @DisplayName("int 범위를 벗어난 숫자가 포함되어 있을 경우 IllegalArgumentException을 발생시켜야 한다.")
    @Test
    void testProcessWithOutOfRangeNumbers() {
        // given
        String numbersWithOutOfRange = "1, 2, 3, 4, 5, 2147483648";

        // when & then
        assertThatThrownBy(() -> winningNumbers.process(numbersWithOutOfRange))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_AMOUNT_MESSAGE.getMessage());
    }

    @DisplayName("숫자 내부에 공백이 포함되어 있을 경우 IllegalArgumentException을 발생시켜야 한다.")
    @Test
    void testensureNotBlank() {
        // given
        String numbersWithOutOfRange = "1, 2, 3, 4, 5, 1  2";

        // when & then
        assertThatThrownBy(() -> winningNumbers.process(numbersWithOutOfRange))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.PLEASE_NOT_INPUT_BETWEEN_NUMBER_BLANK.getMessage());
    }
}

