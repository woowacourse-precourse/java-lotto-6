package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
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

}

