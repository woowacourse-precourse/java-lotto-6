package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.Constants;

class LottoNumbersValidatorTest {

    @ParameterizedTest
    @MethodSource("provideDataForValidateNumbersSize")
    @DisplayName("로또 번호 예외 처리: 6개의 숫자가 아닌 경우")
    void givenList_whenValidateNumbersSize_thenThrowException(List<Integer> numbers) {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumbersValidator.validate(numbers))
                .withMessageStartingWith(Constants.ERROR_MESSAGE)
                .withMessageContaining("로또 번호는 6개여야 합니다.");
    }

    private static Stream<Arguments> provideDataForValidateNumbersSize() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7))
        );
    }

    @Test
    @DisplayName("로또 번호 예외 처리: 중복된 숫자가 존재하는 경우")
    void givenNumbers_whenValidateDuplicationInNumbers_thenThrowException() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumbersValidator.validate(numbers))
                .withMessageStartingWith(Constants.ERROR_MESSAGE)
                .withMessageContaining("로또 번호에 중복된 숫자가 존재할 수 없습니다.");
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @MethodSource("provideDataForOutOfRangeNumbers")
    @DisplayName("로또 번호 예외 처리: 1 ~ 45 범위를 벗어난 경우")
    void givenOutOfRangeNumbers_whenValidateNumberRange_thenThrowException(List<Integer> numbers) {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumbersValidator.validate(numbers))
                .withMessageStartingWith(Constants.ERROR_MESSAGE)
                .withMessageContaining("로또 번호는 1 ~ 45 숫자만 가능합니다.");
    }

    private static Stream<Arguments> provideDataForOutOfRangeNumbers() {
        return Stream.of(
                Arguments.of(List.of(0, 1, 2, 3, 4, 45)),
                Arguments.of(List.of(1, 2, 3, 4, 45, 46))
        );
    }

    @Test
    @DisplayName("로또 번호 예외 처리 통과")
    void givenNumbers_whenValidate_thenNoException() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when & then
        assertThatNoException()
                .isThrownBy(() -> LottoNumbersValidator.validate(numbers));
    }

}
