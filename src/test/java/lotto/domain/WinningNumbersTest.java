package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import lotto.constant.ExceptionMessage;
import lotto.util.NumberConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    private WinningNumbers winningNumbers;
    private NumberConverter numberConverter;

    @BeforeEach
    void setUp() {
        numberConverter = mock(NumberConverter.class);
        winningNumbers = new WinningNumbers(numberConverter);
    }

    @Test
    @DisplayName("정상적인 숫자 문자열을 처리하여 정수 리스트를 반환한다.")
    void process_ValidNumbers_ReturnsIntegerList() {
        // given
        String numbers = "1, 2, 3, 4, 5, 6";
        when(numberConverter.convert("1")).thenReturn(1);
        when(numberConverter.convert("2")).thenReturn(2);
        when(numberConverter.convert("3")).thenReturn(3);
        when(numberConverter.convert("4")).thenReturn(4);
        when(numberConverter.convert("5")).thenReturn(5);
        when(numberConverter.convert("6")).thenReturn(6);

        // when
        List<Integer> result = winningNumbers.process(numbers);

        // then
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("숫자 문자열이 쉼표로 시작할 때 예외를 발생시킨다.")
    void process_StartingComma_ThrowsException() {
        // given
        String numbersWithStartingComma = ",1, 2, 3, 4, 5, 6";

        // when & then
        assertThatThrownBy(() -> winningNumbers.process(numbersWithStartingComma))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_COMMA_USAGE.getMessage());
    }

    @Test
    @DisplayName("숫자 문자열이 쉼표로 끝날 때 예외를 발생시킨다.")
    void process_EndingComma_ThrowsException() {
        // given
        String numbersWithEndingComma = "1, 2, 3, 4, 5, 6,";

        // when & then
        assertThatThrownBy(() -> winningNumbers.process(numbersWithEndingComma))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_COMMA_USAGE.getMessage());
    }

    @Test
    @DisplayName("숫자 문자열에 연속된 쉼표가 있을 때 예외를 발생시킨다.")
    void process_ConsecutiveCommas_ThrowsException() {
        // given
        String numbersWithConsecutiveCommas = "1, 2,, 3, 4, 5, 6";

        // when & then
        assertThatThrownBy(() -> winningNumbers.process(numbersWithConsecutiveCommas))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_COMMA_USAGE.getMessage());
    }

}

