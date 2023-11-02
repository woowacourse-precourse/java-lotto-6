package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.exception.ExceptionMessage.LottoException.LOTTO_NUMBER_IS_NOT_IN_RANGE;
import static lotto.exception.ExceptionMessage.LottoException.LOTTO_SIZE_IS_NOT_FULFILL;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @ParameterizedTest
    @MethodSource("invalidSize")
    @DisplayName("로또 번호의 개수가 6개가 아니면(초과 or 미만) 예외가 발생한다.")
    void throwExceptionByInvalidLottoSize(final List<Integer> numbers) {
        assertThatThrownBy(() -> Lotto.from(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_SIZE_IS_NOT_FULFILL.message);
    }

    private static Stream<Arguments> invalidSize() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7)), // 초과
                Arguments.of(List.of(1, 2, 3, 4, 5)) // 미만
        );
    }

    @ParameterizedTest
    @MethodSource("invalidRange")
    @DisplayName("로또 번호의 범위가 1..45 이외라면 예외가 발생한다")
    void throwExceptionByLottoNumberIsNotInRange(final List<Integer> numbers) {
        assertThatThrownBy(() -> Lotto.from(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_IS_NOT_IN_RANGE.message);
    }

    private static Stream<Arguments> invalidRange() {
        return Stream.of(
                Arguments.of(List.of(0, 1, 2, 3, 4, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 46))
        );
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void throwExceptionByLottoNumberIsNotInRange() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
