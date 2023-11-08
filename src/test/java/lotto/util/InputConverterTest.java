package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputConverterTest {

    private InputConverter inputConverter;

    @BeforeEach
    void setup() {
        inputConverter = new InputConverter();
    }

    @Test
    @DisplayName("Integer로 바꿔서 리턴한다.")
    void testToInteger() {
        String input = "1234";
        Integer result = inputConverter.inputToNumber(input);

        assertThat(result).isInstanceOf(Integer.class);
    }

    @Test
    @DisplayName("','를 기준으로 분리한다.")
    void testToSplit() {
        String input = "1,2,3";
        List<String> result = Arrays.stream(inputConverter.inputToSplit(input)).toList();
        List<String> expected = List.of("1", "2", "3");

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("숫자가 아니면 ''으로 치환한다.")
    void testCheckIsNumber() {
        String input = "123  ";
        String result = inputConverter.translate(input);

        assertThat(result).isEqualTo("123");
    }

}