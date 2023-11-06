package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.Constants;

class InputValidatorTest {

    @ParameterizedTest
    @NullSource
    @DisplayName("입력 공통 예외 처리: null인 경우")
    void givenNull_whenValidate_thenThrowException(String input) {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validate(input))
                .withMessageStartingWith(Constants.ERROR_MESSAGE)
                .withMessageContaining("입력 값이 null 입니다.");
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(strings = {"", "  "})
    @DisplayName("입력 공통 예외 처리: 빈 문자열인 경우")
    void givenEmptyAndWhitespaces_whenValidate_thenThrowException(String input) {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validate(input))
                .withMessageStartingWith(Constants.ERROR_MESSAGE)
                .withMessageContaining("값을 입력해 주세요.");
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(strings = {"1:2:3:4:5:6", "일,이,삼,사,오,육", "1000원", "1000won", "1000원!", "1, 2, 3, 4, 5, 6"})
    @DisplayName("입력 공통 예외 처리: 숫자와 쉼표 외 다른 문자가 입력된 경우")
    void givenUnmatchedInput_whenValidate_thenThrowException(String input) {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validate(input))
                .withMessageStartingWith(Constants.ERROR_MESSAGE)
                .withMessageContaining("숫자와 구분자 쉼표(,)로 구분한 숫자들만 입력할 수 있습니다.");
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(strings = {"010000", "01,02,03,04,05,06"})
    @DisplayName("입력 공통 예외 처리: 0으로 시작하는 숫자를 입력한 경우")
    void givenWrongNumber_whenValidate_thenThrowException(String input) {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validate(input))
                .withMessageStartingWith(Constants.ERROR_MESSAGE)
                .withMessageContaining("숫자는 0으로 시작할 수 없습니다.");
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(strings = {"8000", "10000", "1,2,3,4,5,6", "7"})
    @DisplayName("입력 공통 예외 처리 통과")
    void givenInput_whenValidate_thenNoException(String input) {
        // when & then
        assertThatNoException()
                .isThrownBy(() -> InputValidator.validate(input));
    }


}
