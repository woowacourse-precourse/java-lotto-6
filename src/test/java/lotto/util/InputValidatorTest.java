package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    private static InputValidator inputValidator;

    @DisplayName("숫자 값만 포함되어 있는지 확인")
    @Test
    void isNumber() {
        assertThat(inputValidator.isNumber("1000J"))
                .isFalse();
        assertThat(inputValidator.isNumber("100012"))
                .isTrue();
    }

    @DisplayName("로또 번호 입력 개수가 맞는지 확인")
    @Test
    void isCorrectCount() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        assertThat(inputValidator.isCorrectCount(numbers.size()))
                .isTrue();

        numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThat(inputValidator.isCorrectCount(numbers.size()))
                .isFalse();
    }

    @DisplayName("로또 번호가 1~45 사이의 값이 맞는지 확인")
    @Test
    void isCorrectNumber() {
        assertThat(inputValidator.isCorrectNumber(35))
                .isTrue();

        assertThat(inputValidator.isCorrectNumber(0))
                .isFalse();

        assertThat(inputValidator.isCorrectNumber(57))
                .isFalse();
    }

    @DisplayName("로또 번호 중복 여부 확인")
    @Test
    void isDuplicateNumber() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 6);
        assertThat(inputValidator.isDuplicateNumber(numbers))
                .isTrue();

        numbers = List.of(1, 2, 3, 4, 5, 6);
        assertThat(inputValidator.isDuplicateNumber(numbers))
                .isFalse();
    }
}
