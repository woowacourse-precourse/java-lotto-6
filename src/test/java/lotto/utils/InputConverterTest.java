package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputConverterTest {
    @DisplayName("문자열을 숫자로 변환한다.")
    @Test
    void convertToNumber() {
        int expectedValue = 123;
        String input = "123";
        int convertToNumber = InputConverter.convertToNumber(input);
        assertThat(convertToNumber).isEqualTo(expectedValue);
    }

    @DisplayName("문자열리스트를 숫자리스트로 변환한다.")
    @Test
    void convertToNumbers() {
        List<Integer> expectedValue = Arrays.asList(1, 4, 123, 43, 50);
        List<String> input = Arrays.asList("1", "4", "123", "43", "50");
        List<Integer> convertToNumbers = InputConverter.convertToNumbers(input);
        assertThat(convertToNumbers).isEqualTo(expectedValue);
    }
}
