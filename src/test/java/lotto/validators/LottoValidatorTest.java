package lotto.validators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoValidatorTest {

    @DisplayName("올바른 로또 번호는 예외가 발생하지 않는다.")
    @Test
    void validateLottoConstructor() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        assertDoesNotThrow(() -> {
            LottoValidator.validateLottoConstructor(numbers);
        });
    }

    @DisplayName("발행할 로또의 번호 길이가 기준보다 길면 예외가 발생한다.")
    @Test
    void validateLottoConstructorByOverSize() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        assertThatThrownBy(() -> LottoValidator.validateLottoConstructor(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("발행할 로또의 번호 범위가 기준에 벗어나면 예외가 발생한다.")
    @Test
    void validateLottoConstructorByWrongRange() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);

        assertThatThrownBy(() -> LottoValidator.validateLottoConstructor(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("발행할 로또 번호에 중복이 있으면 예외가 발생한다.")
    @Test
    void validateLottoConstructorByDuplicatedNumber() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> LottoValidator.validateLottoConstructor(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}