package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    private final String error = "[ERROR]";

    @ParameterizedTest
    @NullSource
    @DisplayName("입력 공통 예외 처리: null인 경우")
    void givenNull_whenValidate_thenThrowException(String input) {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validate(input))
                .withMessageStartingWith(error)
                .withMessageContaining("입력 값이 null 입니다.");
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(strings = {"", "  "})
    @DisplayName("입력 공통 예외 처리: 빈 문자열인 경우")
    void givenEmptyAndWhitespaces_whenValidate_thenThrowException(String input) {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validate(input))
                .withMessageStartingWith(error)
                .withMessageContaining("값을 입력해 주세요.");
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(strings = {"1:2:3:4:5:6", "일,이,삼,사,오,육", "1000원", "1000won", "1000원!", "1, 2, 3, 4, 5, 6"})
    @DisplayName("입력 공통 예외 처리: 숫자와 쉼표 외 다른 문자가 입력된 경우")
    void givenUnmatchedInput_whenValidate_thenThrowException(String input) {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validate(input))
                .withMessageStartingWith(error)
                .withMessageContaining("숫자와 구분자 쉼표(,)만 입력할 수 있습니다.");
    }

}
