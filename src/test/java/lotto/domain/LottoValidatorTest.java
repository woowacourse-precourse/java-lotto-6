package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LottoValidatorTest {

    @DisplayName("중복된 숫자가 있는 경우 예외를 발생시킨다.")
    @Test
    void validateDuplicateNumber() {
        // given
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        // when & then
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> LottoValidator.validateDuplicateNumber(duplicateNumbers)
        );
    }

    @DisplayName("로또 번호의 개수가 6개가 아닌 경우 예외를 발생시킨다.")
    @Test
    void validateSize() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // when & then
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> LottoValidator.validateSize(numbers)
        );
    }

    @DisplayName("로또 번호가 1 ~ 45 사이의 숫자가 아닌 경우 예외를 발생시킨다.")
    @Test
    void validateNumberRange() {
        // given
        int number = 46;

        // when & then
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> LottoValidator.validateNumberRange(number)
        );
    }
}
