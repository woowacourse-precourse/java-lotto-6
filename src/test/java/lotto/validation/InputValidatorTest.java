package lotto.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputValidatorTest {

    InputValidator inputValidator = new InputValidator();

    @ParameterizedTest
    @CsvSource(value = {"3, true", "41, true", "1w, false", "qwe, false"})
    @DisplayName("입력 숫자 여부 테스트")
    void 입력_숫자_여부_테스트(String input, boolean expected) {
        Assertions.assertThat(inputValidator.isNumber(input)).isEqualTo(expected);
    }

}