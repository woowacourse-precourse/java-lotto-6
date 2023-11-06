package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidateTest {
    Validate validate = new Validate();

    @DisplayName("입력받은 값이 숫자가 아닌경우")
    @Test
    void validateInputPrice_예외_테스트_Not_Number() {
        final String INPUT = "삼천원";
        final long RESULT = -1;

        assertThat(validate.validateInputPrice(INPUT)).isEqualTo(RESULT);
    }

    @DisplayName("입력 받은 값이 1000에 나누어 떨어지지 않는 경우")
    @Test
    void validateInputPrice_예외_테스트_Can_Not_Divide() {
        final String INPUT = "1300";
        final long RESULT = -1;

        assertThat(validate.validateInputPrice(INPUT)).isEqualTo(RESULT);
    }

    @DisplayName("입력 받은 값이 정상일 경우")
    @Test
    void validateInputPrice_메서드_정상_작동() {
        final String INPUT = "10000";
        final long RESULT = 10000;

        assertThat(validate.validateInputPrice(INPUT)).isEqualTo(RESULT);
    }
}
