package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import lotto.validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ErrorMessageSenderTest {

    static class TestValidator implements Validator<String> {
        @Override
        public String validate(String input) {
            if (input.equals("NO_ERROR")) {
                return "EMPTY_OPTIONAL";
            }
            throw new IllegalArgumentException("NOT_EMPTY_OPTIONAL");
        }
    }

    @DisplayName("에러 미발생시 빈 Optional 반환")
    @Test
    void success_HasNotError() {
        // give
        TestValidator validator = new TestValidator();
        String input = "NO_ERROR";
        // when
        Optional<String> optional = ErrorMessageSender.validateAndGetErrorMessage(validator, input);
        // then
        assertThat(optional).isEmpty();
    }

    @DisplayName("에러 발생시 에러 메시지를 담은 Optional을 반환")
    @Test
    void success_HasError() {
        // give
        TestValidator validator = new TestValidator();
        String input = "ERROR";
        // when
        Optional<String> optional = ErrorMessageSender.validateAndGetErrorMessage(validator, input);
        // then
        assertThat(optional.get()).isEqualTo("NOT_EMPTY_OPTIONAL");
    }
}