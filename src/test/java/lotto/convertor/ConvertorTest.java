package lotto.convertor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ConvertorTest {

    @DisplayName("문자를 숫자로 변환할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "999", "-1", "-999", "1234567", "-1234567"})
    void toInt(String input) {
        // given // when
        int anInt = Convertor.toInt(input);
        int target = Integer.parseInt(input);

        // then
        assertThat(anInt).isEqualTo(target);
    }

    @DisplayName("입력받은 문자가 숫자가 아니면 안된다.")
    @ParameterizedTest
    @ValueSource(strings = {"A", "111a", "-1A", "-A99"})
    void toIntNotInt(String input) {
        // given when then
        assertThatThrownBy(() -> Convertor.toInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_INTEGER.getMessage());
    }

    @DisplayName("입력받은 문자를 ,로 분할하여 반환할 수 있다.")
    @ParameterizedTest
    @MethodSource("numberProvider")
    void toIntegerList(String input, int count, List<Integer> answer) {
        // given
        // when
        List<Integer> integers = Convertor.toIntegerList(input);

        // then
        assertThat(integers).hasSize(count)
                .isEqualTo(answer);
    }

    static Stream<Arguments> numberProvider() {
        return Stream.of(
                arguments("7,8,9,10,11,12", 6, List.of(7, 8, 9, 10, 11, 12)),
                arguments("1,7,8,9,10,11", 6, List.of(1, 7, 8, 9, 10, 11)),
                arguments("1,2,7,8,9,10", 6, List.of(1, 2, 7, 8, 9, 10)),
                arguments("1,2,3,7,8,9", 6, List.of(1, 2, 3, 7, 8, 9))
        );
    }
}