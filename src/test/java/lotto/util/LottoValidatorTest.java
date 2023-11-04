package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoValidatorTest {

    @DisplayName("범위 밖의 숫자가 존재하면 예외 처리")
    @ParameterizedTest
    @MethodSource("generateLottoNumbers")
    void lottoNumbersOutOfRangeTest(List<Integer> lottoNumbers) {
        assertThatThrownBy(() -> LottoValidator.validateLotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> generateLottoNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 46)),
                Arguments.of(List.of(0, 1, 2, 3, 4, 5)),
                Arguments.of(List.of(-3, 4, 5, 6, 7, 8))
        );
    }
}