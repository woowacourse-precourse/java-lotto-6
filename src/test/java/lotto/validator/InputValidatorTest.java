package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

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

}
