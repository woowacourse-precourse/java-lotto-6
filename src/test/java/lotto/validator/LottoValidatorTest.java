package lotto.validator;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoValidatorTest {
    private LottoValidator lottoValidator = new LottoValidator();

    @Test
    void checkSize() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        assertThatCode(() -> lottoValidator.checkSize(numbers))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("numbersProviderForSize")
    void checkInvalidSize(List<Integer> numbers) {
        assertThatThrownBy(() -> lottoValidator.checkSize(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("[ERROR] 숫자는 6개만 입력하세요.");
    }

    private static Stream<Arguments> numbersProviderForSize() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7))
        );
    }

    @Test
    void checkRange() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        assertThatCode(() -> lottoValidator.checkRange(numbers))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("numbersProviderForRange")
    void checkInvalidRangeNumber(List<Integer> numbers) {
        assertThatThrownBy(() -> lottoValidator.checkRange(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("[ERROR] 입력 가능한 로또 숫자 범위는 1 ~ 45입니다.");
    }

    private static Stream<Arguments> numbersProviderForRange() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 23, 44, 55, 24)),
                Arguments.of(List.of(0, 12, 3, 4, 5, 45)),
                Arguments.of(List.of(1, 2, 23, 44, 45, 46))
        );
    }
}
