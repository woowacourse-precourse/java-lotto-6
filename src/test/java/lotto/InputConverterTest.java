package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputConverterTest {
    private InputConverter inputConverter;

    @BeforeEach
    void initialize() {
        inputConverter = new InputConverter();
    }

    @DisplayName("입력된 당첨 번호는 쉼표를 기준으로 구분해 List<Integer>로 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void convertToListToInteger(String input) {
        List<Integer> numbers = inputConverter.convertToListOfInteger(input);

        assertThat(numbers).doesNotContainNull().containsOnly(1, 2, 3, 4, 5, 6);
    }
}