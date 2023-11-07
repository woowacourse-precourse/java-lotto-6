package lotto.domain;

import lotto.domain.Lotto;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("로또")
class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() ->Lotto.create(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> Lotto.create(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외 발생")
    @ParameterizedTest
    @MethodSource("numbersOverSizeDummy")
    void createLottoByOverSizeTest(List<Integer> numbersOverSize) {
        assertThrows(IllegalArgumentException.class,
                () -> Lotto.create(numbersOverSize));

    }

    @DisplayName("로또 번호의 개수가 6개 보다 적으면 예외 발생")
    @ParameterizedTest
    @MethodSource("numbersSmallSizeDummy")
    void createLottoBySmallSizeTest(List<Integer> numbersSmallSize) {
        assertThrows(IllegalArgumentException.class,
                () -> Lotto.create(numbersSmallSize));

    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외 발생")
    @ParameterizedTest
    @MethodSource("duplicatedNumbersDummy")
    void createLottoByDuplicatedNumbersTest(List<Integer> duplicatedNumbers) {
        assertThrows(IllegalArgumentException.class,
                () -> Lotto.create(duplicatedNumbers));
    }

    @DisplayName("로또 번호에 허용 범위를 벗어난 숫자가 있으면 예외 발생")
    @ParameterizedTest
    @MethodSource("overRangeNumbersDummy")
    void createLottoByOverRangeNumbersTest(List<Integer> overRangeNumbers) {
        assertThrows(IllegalArgumentException.class,
                () -> Lotto.create(overRangeNumbers));
    }


    @DisplayName("생성 성공 테스트")
    @ParameterizedTest()
    @MethodSource("lottoNumbersDummy")
    void createLottoSuccessTest(List<Integer> lottoNumbers) {
        assertDoesNotThrow(() -> Lotto.create(lottoNumbers));
    }

    @DisplayName("당첨 로또와 비교 기능 테스트")
    @ParameterizedTest()
    @MethodSource("compareWinnerLottoSuccessDummy")
    void compareWinnerLottoSuccessTest(Lotto lotto, List<Integer> winnerNumbers, Integer bonusNumber, Prize expected) {
        Prize result = lotto.compareWithWinnerLotto(winnerNumbers, bonusNumber);
        assertEquals(expected.getCountOfMatchedNumber(), result.getCountOfMatchedNumber());
        assertEquals(expected.isBonusNumber(), result.isBonusNumber());
    }

    @DisplayName("로또 번호 문자열로 표현하는 기능 테스트")
    @ParameterizedTest
    @MethodSource("toStringSuccessDummy")
    void toStringSuccessTest(Lotto lotto, String expected) {
        String result = lotto.toString();
        assertThat(result.equals(expected)).isTrue();
    }




    static Stream<Arguments> overRangeNumbersDummy() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 49)),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 100)),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 50)),
                Arguments.arguments(List.of(-1, 2, 3, 4, 5, 50))
        );
    }
    static Stream<Arguments> numbersOverSizeDummy() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6, 7)),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6, 7, 8)),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9))
        );
    }

    static Stream<Arguments> numbersSmallSizeDummy() {
        return Stream.of(
                Arguments.arguments(List.of(1)),
                Arguments.arguments(List.of(1, 2)),
                Arguments.arguments(List.of(1, 2, 3))
        );
    }

    static Stream<Arguments> duplicatedNumbersDummy() {
        return Stream.of(
                Arguments.arguments(List.of(1, 1, 2, 3, 4, 5)),
                Arguments.arguments(List.of(1, 2, 2, 3, 4, 5)),
                Arguments.arguments(List.of(1, 2, 3, 3, 4, 5))
        );
    }

    static Stream<Arguments> lottoNumbersDummy() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6)),
                Arguments.arguments(List.of(1, 2, 3, 9, 12, 30)),
                Arguments.arguments(List.of(1, 2, 3, 19, 20, 42))
        );
    }

    static Stream<Arguments> compareWinnerLottoSuccessDummy() {
        return Stream.of(
                Arguments.arguments(Lotto.create(
                                List.of(1, 2, 3, 4, 5, 6)
                        ),
                        List.of(1, 2, 3, 8, 9, 10),
                        7,
                        Prize.of(3, false)
                ),
                Arguments.arguments(Lotto.create(
                                List.of(1, 2, 3, 4, 5, 6)
                        ),
                        List.of(1, 2, 15, 8, 9, 10),
                        3,
                        Prize.of(2, true)
                ),
                Arguments.arguments(Lotto.create(
                                List.of(1, 2, 3, 4, 5, 8)
                        ),
                        List.of(1, 2, 5, 8, 9, 10),
                        3,
                        Prize.of(4, true)
                )
        );

    }
    static Stream<Arguments> toStringSuccessDummy() {
        return Stream.of(
                Arguments.arguments(
                        Lotto.create(List.of(1, 2, 3, 4, 5, 6)),
                        "[1, 2, 3, 4, 5, 6]"
                ),
                Arguments.arguments(
                        Lotto.create(List.of(1, 2, 3, 7, 5, 6)),
                        "[1, 2, 3, 7, 5, 6]"
                ),
                Arguments.arguments(
                        Lotto.create(List.of(1, 2, 3, 4, 15, 6)),
                        "[1, 2, 3, 4, 15, 6]"
                )
        );
    }
}