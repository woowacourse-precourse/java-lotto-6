package lotto.validator;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersValidatorTest {

    private static LottoNumbersValidator validator;

    @BeforeAll
    private static void beforeAll() {
        validator = new LottoNumbersValidator();
    }

    @Test
    @DisplayName("로또번호 생성검증: 길이가 6인지")
    void whenLengthIsNotSix() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(numbers)
        );
    }

    @Test
    @DisplayName("로또번호 생성검증: 중복된 숫자가 있는 지")
    void whenContainsDuplicateNumbers() {
        List<Integer> numbers = List.of(5, 1, 2, 3, 4, 5);
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(numbers)
        );
    }

    @Test
    @DisplayName("로또번호 생성검증: 올바른 로또번호")
    void whenValidNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        validator.validate(numbers);
    }
}