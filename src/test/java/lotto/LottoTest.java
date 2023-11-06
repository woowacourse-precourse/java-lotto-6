package lotto;

import java.util.stream.Stream;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 객체에 대한 테스트")
class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("lowerSizeProvider")
    void createLottoByLowerSize(List<Integer> lottoNumbers) {
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> lowerSizeProvider() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5)),
                Arguments.of(List.of(1, 2, 3)),
                Arguments.of(List.of(1)),
                Arguments.of(List.of())
        );
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~45 를 벗어난 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("outOfRangeProvider")
    void createLottoByOutOfRange(List<Integer> lottoNumbers) {
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> outOfRangeProvider() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 0, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 46))
        );
    }

    @DisplayName("정상 케이스인 경우 예외를 발생시키지 않는다.")
    @ParameterizedTest
    @MethodSource("validNumberProvider")
    void createLottoWithValidNumber(List<Integer> lottoNumbers) {
        Assertions.assertThatNoException()
                .isThrownBy(() -> new Lotto(lottoNumbers));
    }

    static Stream<Arguments> validNumberProvider() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(8, 10, 25, 45, 1, 44)),
                Arguments.of(List.of(3, 11, 20, 28, 34, 42)),
                Arguments.of(List.of(2, 9, 17, 25, 35, 43)),
                Arguments.of(List.of(5, 13, 22, 30, 39, 44)),
                Arguments.of(List.of(7, 15, 24, 31, 38, 45)),
                Arguments.of(List.of(1, 10, 18, 27, 36, 41)),
                Arguments.of(List.of(45, 1, 26, 12, 21, 8)),
                Arguments.of(List.of(4, 12, 21, 29, 37, 42)),
                Arguments.of(List.of(35, 16, 41, 25, 36, 13))
        );
    }
}