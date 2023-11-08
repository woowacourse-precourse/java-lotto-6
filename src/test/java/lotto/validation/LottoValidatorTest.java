package lotto.validation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoValidatorTest {

    @Test
    @DisplayName("올바른 숫자 개수를 가진 로또 번호 검증")
    void validateCorrectNumberCount() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> LottoValidator.validate(numbers));
    }

    @Test
    @DisplayName("잘못된 숫자 개수를 가진 로또 번호 검증")
    void validateIncorrectNumberCount() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThrows(IllegalArgumentException.class, () -> LottoValidator.validate(numbers));
    }

    @Test
    @DisplayName("중복된 숫자가 있는 로또 번호 검증")
    void validateDuplicateNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 5, 6);
        assertThrows(IllegalArgumentException.class, () -> LottoValidator.validate(numbers));
    }

    @Test
    @DisplayName("범위를 벗어난 숫자가 있는 로또 번호 검증")
    void validateNumbersOutOfRange() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 50);
        assertThrows(IllegalArgumentException.class, () -> LottoValidator.validate(numbers));
    }

    @Test
    @DisplayName("null인 로또 번호 리스트 검증")
    void validateNullList() {
        assertThrows(IllegalArgumentException.class, () -> LottoValidator.validate(null));
    }
}