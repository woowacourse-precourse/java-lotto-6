package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConverterTest {
    @DisplayName("숫자로 변환 가능한 값을 입력할 경우 해당 값을 숫자로 변환한다.")
    @Test
    void tryConvertToNumericWithNumericValue() {
        String input = "1";
        int result = Converter.convertToNumeric(input);

        assertThat(result).isEqualTo(1);
    }

    @DisplayName("숫자로 변환 불가능한 값을 입력할 경우 예외가 발생한다.")
    @Test
    void tryConvertToNumericWithNonNumericValue() {
        String input = "11aa";

        assertThatThrownBy(() -> Converter.convertToNumeric(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구분자로 주어진 값을 구분한다.")
    @Test
    void tryConvertWinningNumberWithDelimiter() {
        String input = "1,2,3,4,5,6";
        List<Integer> result = Converter.convertWinningNumber(input);

        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("구분자가 없을 경우 주어진 값을 그대로 반환한다.")
    @Test
    void tryConvertWinningNumberWithoutDelimiter() {
        String input = "1";
        List<Integer> result = Converter.convertWinningNumber(input);

        assertThat(result).containsExactly(1);
    }
}