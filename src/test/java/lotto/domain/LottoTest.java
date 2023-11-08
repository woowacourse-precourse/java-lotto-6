package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

    @DisplayName("허용 숫자 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("outOfRangeProvider")
    void createLottoByOutOfRange(List<Integer> lottoNumbers) {
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> outOfRangeProvider() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, LottoOption.LOTTO_START_INCLUSIVE - 1, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5, LottoOption.LOTTO_END_INCLUSIVE + 1))
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

    @DisplayName("랜덤 로또 생성 시 규칙에 맞게 생성된다.")
    @RepeatedTest(50)
    void createRandomLottoTest() {
        Lotto randomLotto = Lotto.createRandomLotto(new Money(LottoOption.LOTTO_PRICE));
        List<Integer> numbers = randomLotto.getNumbers();

        Assertions.assertThat(numbers).hasSize(LottoOption.LOTTO_SIZE);
        numbers.forEach(number -> {
            Assertions.assertThat(number).isBetween(LottoOption.LOTTO_START_INCLUSIVE, LottoOption.LOTTO_END_INCLUSIVE);
        });
    }

    @DisplayName("로또 번호가 일치하는 개수를 반환한다.")
    @ParameterizedTest
    @MethodSource("getMatchCountProvider")
    void getMatchCountTest(Lotto lotto, int expected) {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int actual = lotto.getMatchCount(winningLotto);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> getMatchCountProvider() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), 5),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 8, 9)), 4),
                Arguments.of(new Lotto(List.of(1, 2, 3, 10, 11, 12)), 3),
                Arguments.of(new Lotto(List.of(1, 2, 13, 14, 15, 16)), 2),
                Arguments.of(new Lotto(List.of(1, 17, 18, 19, 20, 21)), 1),
                Arguments.of(new Lotto(List.of(22, 23, 24, 25, 26, 27)), 0)
        );
    }
}