package lotto.view.input;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputTest {
    @DisplayName("입력에서 공백 문자를 모두 제거한 값을 반환한다")
    @ParameterizedTest
    @CsvSource({"'   ',''", "'\t  ',''", "' a b c ',abc"})
    void trimmed(String inputString, String expected) {
        Input input = new Input(inputString);

        assertThat(input.trimmed()).isEqualTo(expected);
    }
}
