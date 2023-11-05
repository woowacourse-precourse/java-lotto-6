package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConverterTest {
    @Test
    @DisplayName("입력 받은 문자열을 int형으로 잘 변환해주는지 확인한다.")
    void convertStringToInt() {
        String inputString = "1";

        assertThat(Converter.stringToInt(inputString)).isEqualTo(1);
    }

    @Test
    @DisplayName("형변환이 안되는 문자열 입력 시 예외 발생한다.")
    void convertExceptionOnInvalidInput() {
        assertThatThrownBy(() -> Converter.stringToInt("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("입력 받은 문자열 리스트를 Integer리스트로 잘 변환하는지 확인한다")
    void convertStringListToInteger() {
        List<String> inputNumbers = Arrays.asList("1", "2", "3", "4", "5", "6");

        assertThat(Converter.stringListToIntegers(inputNumbers)).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("형변환이 안되는 문자열 리스트 입력 시 예외 발생한다.")
    void convertExceptionOnInvalidInputList() {
        assertThatThrownBy(() -> Converter.stringListToIntegers(Arrays.asList("1", "a", "3", "4", "5", "6")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자를 입력해주세요.");
    }

}
