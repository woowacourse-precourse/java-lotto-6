package lotto.domain.validation;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoValidationHandlerTest {

    @Test
    @DisplayName("로또 번호가 6개이면 예외가 발생하지 않는다.")
    void validationNumbersSize() {
        // given
        List<Integer> numbers = List.of(1,2,3,4,5,6);

        // when // then
        LottoValidationHandler.validationNumbersSize(numbers);
    }

    @Test
    @DisplayName("로또 번호가 6개 보다 크면 예외가 발생한다.")
    void validationNumbersSizeExceptionMoreThan6() {
        // given
        List<Integer> numbers = List.of(1,2,3,4,5,6,7);

        // when // then
        assertThatThrownBy(() -> LottoValidationHandler.validationNumbersSize(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoValidationHandler.INVALID_LOTTO_NUMBERS_SIZE_MESSAGE);
    }

    @Test
    @DisplayName("로또 번호가 6개 보다 작으면 예외가 발생한다.")
    void validationNumbersSizeExceptionLessThan6() {
        // given
        List<Integer> numbers = List.of(1,2,3,4,5);

        // when // then
        assertThatThrownBy(() -> LottoValidationHandler.validationNumbersSize(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoValidationHandler.INVALID_LOTTO_NUMBERS_SIZE_MESSAGE);
    }

    @Test
    @DisplayName("로또 번호가 중복된 숫자가 없으면 예외가 발생하지 않는다.")
    void validateDuplicatedNumbers() {
        // given
        List<Integer> numbers = List.of(1,2,3,4,5,6);

        // when // then
        LottoValidationHandler.validateDuplicatedNumbers(numbers);
    }

    @Test
    @DisplayName("로또 번호가 중복된 숫자가 있으면 예외가 발생한다.")
    void validateDuplicatedNumbersException() {
        // given
        List<Integer> numbers = List.of(1,2,3,4,5,5);

        // when // then
        assertThatThrownBy(() -> LottoValidationHandler.validateDuplicatedNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoValidationHandler.INVALID_DUPLICATED_LOTTO_NUMBERS_MESSAGE);
    }

    @Test
    @DisplayName("1~45 사이의 로또 번호로 구성되어 있으면 예외가 발생하지 않는다.")
    void validationNumbersRange() {
        // given
        List<Integer> numbers = List.of(1,2,3,4,5,45);

        // when // then
        LottoValidationHandler.validationNumbersRange(numbers);
    }

    @Test
    @DisplayName("1~45 사이의 로또 번호로 구성되어 있지 않으면 예외가 발생한다.")
    void validationNumbersRangeException() {
        // given
        List<Integer> numbers = List.of(-1,0,1,2,3,46);

        // when // then
        assertThatThrownBy(() -> LottoValidationHandler.validationNumbersRange(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoValidationHandler.INVALID_LOTTO_NUMBERS_RANGE_MESSAGE);
    }
}