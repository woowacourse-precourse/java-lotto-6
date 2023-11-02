package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static lotto.exception.ExceptionMessage.LottoException.LOTTO_NUMBER_IS_NOT_IN_RANGE;
import static lotto.exception.ExceptionMessage.LottoException.LOTTO_NUMBER_MUST_BE_UNIQUE;
import static lotto.exception.ExceptionMessage.LottoException.LOTTO_SIZE_IS_NOT_FULFILL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTest {
    @ParameterizedTest
    @MethodSource("invalidSize")
    @DisplayName("로또 번호의 개수가 6개가 아니면(초과 or 미만) 예외가 발생한다.")
    void throwExceptionByInvalidLottoSize(final List<Integer> numbers) {
        assertThatThrownBy(() -> Lotto.create(numbers))
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
        assertThatThrownBy(() -> Lotto.create(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_IS_NOT_IN_RANGE.message);
    }

    private static Stream<Arguments> invalidRange() {
        return Stream.of(
                Arguments.of(List.of(0, 1, 2, 3, 4, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 46))
        );
    }

    @ParameterizedTest
    @MethodSource("duplicateNumber")
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다")
    void throwExceptionByLottoNumberIsNotUnique(final List<Integer> numbers) {
        assertThatThrownBy(() -> Lotto.create(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_MUST_BE_UNIQUE.message);
    }

    private static Stream<Arguments> duplicateNumber() {
        return Stream.of(
                Arguments.of(List.of(1, 1, 2, 3, 4, 5)),
                Arguments.of(List.of(1, 1, 1, 2, 3, 4)),
                Arguments.of(List.of(1, 1, 1, 1, 2, 3)),
                Arguments.of(List.of(1, 1, 1, 1, 1, 2)),
                Arguments.of(List.of(1, 1, 1, 1, 1, 1))
        );
    }

    @Test
    @DisplayName("Lotto를 생성한다")
    void create() {
        // when
        final Lotto lottoA = Lotto.create(Arrays.asList(1, 3, 2, 4, 5, 6)); // sortable -> Arrays.asList
        final Lotto lottoB = Lotto.create(Arrays.asList(44, 1, 10, 23, 18, 6));

        // then
        assertAll(
                () -> assertThat(lottoA.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6),
                () -> assertThat(lottoB.getNumbers()).containsExactly(1, 6, 10, 18, 23, 44)
        );
    }
}
