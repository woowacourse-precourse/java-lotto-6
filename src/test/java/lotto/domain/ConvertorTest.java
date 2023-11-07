package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ConvertorTest {

    @ParameterizedTest
    @DisplayName("1-45 사이의 숫자면 리스트 생성")
    @ValueSource(strings = "1,3,18,45,27,15")
    void convertToIntegersSuccess(String input) {
        List<Integer> numbers = Convertor.convertToNumbers(input);
        assertThat(numbers).contains(1, 3, 18, 45, 27, 15);
    }

    @ParameterizedTest
    @DisplayName("1-45 이외의 숫자, 문자 입력시 예외 발생")
    @ValueSource(strings = {"1,3,18,45,27,46", "$,3,18,45,27,15", "1,3,18,45,27, "})
    void convertToIntegersFail(String input) {
        assertThatThrownBy(() -> Convertor.convertToNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}