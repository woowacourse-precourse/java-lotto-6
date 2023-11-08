package lotto.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputValidatorTest {

    private static InputValidator inputValidator;

    @BeforeEach
    void beforeEach() {
        inputValidator = InputValidator.getInstance();
    }

    @DisplayName("숫자인 경우 String을 int로 변환한다.")
    @Test
    void validateNumberSuccess() {
        assertThat(inputValidator.validateNumber("3")).isEqualTo(3);
    }

    @DisplayName("문자인 경우 예외가 발생한다.")
    @Test
    void validateNumberByCharacter() {
        assertThatThrownBy(() -> inputValidator.validateNumber("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("문자를 입력할 수 없습니다.");
    }

    @DisplayName("숫자인 경우 String 리스트를 int 리스트로 변환한다.")
    @Test
    void validateNumbersSuccess() {
        // given
        List<Integer> result = inputValidator.validateNumbers(List.of("1", "2", "3"));

        // then
        assertThat(result.contains(1)).isTrue();
        assertThat(result.contains(2)).isTrue();
        assertThat(result.contains(3)).isTrue();
        assertThat(result.size()).isEqualTo(3);
    }

    @DisplayName("문자인 경우 예외가 발생한다.")
    @Test
    void validateNumbersByCharacter() {
        assertThatThrownBy(() -> inputValidator.validateNumbers(List.of("1", "2", "a")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("문자를 입력할 수 없습니다.");
    }
}
