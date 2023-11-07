package lotto.lotto.util.validator;

import lotto.util.validator.ListValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ListValidatorTest {
    @DisplayName("비어있는 배열은 예외를 출력한다.")
    @Test
    void validateEmptyList() {
        assertThatThrownBy(() -> ListValidator.validateNotEmpty(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("비어있지 않은 배열을 검증한다.")
    @Test
    void validateNotEmptyList() {
        Assertions.assertDoesNotThrow(() -> ListValidator.validateNotEmpty(List.of(2, 3)));
    }

    @DisplayName("개수가 6개가 아닌 배열은 예외를 출력한다.")
    @Test
    void validateListSizeNotSix() {
        assertThatThrownBy(() -> ListValidator.validateNumbersSize(List.of(2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("개수가 6개인 배열을 검증한다.")
    @Test
    void validateListSizeSix() {
        Assertions.assertDoesNotThrow(() -> ListValidator.validateNumbersSize(List.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("중복 숫자가 포함된 배열은 예외를 출력한다")
    @Test
    void validateDuplicatedNumberList() {
        assertThatThrownBy(() -> ListValidator.validateUniqueNumbers(List.of(2, 3, 4, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복 숫자가 없는 배열을 검증한다.")
    @Test
    void validateNotDuplicatedNumberList() {
        Assertions.assertDoesNotThrow(() -> ListValidator.validateUniqueNumbers(List.of(2, 3, 4, 5, 6, 7)));
    }

    @DisplayName("당첨 번호와 보너스 번호는 중복될 수 없다.")
    @Test
    void validateNumberAlreadyContains() {
        assertThatThrownBy(() ->
                ListValidator.validateNotContains(List.of(2, 3, 4), 2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호와 보너스 번호가 중복되지 않는다.")
    @Test
    void validateNumberNotContains() {
        Assertions.assertDoesNotThrow(() ->
                ListValidator.validateNotContains(List.of(2, 3, 4, 5, 6, 7), 8));
    }
}
