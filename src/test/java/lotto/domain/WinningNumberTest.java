package lotto.domain;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningNumberTest {

    @ParameterizedTest(name = "입력 값 : {0}")
    @MethodSource("generateWinningNumber")
    @DisplayName("중복된 당첨 번호가 입력되면 예외가 발생한다.")
    void 중복된_당첨번호_예외_테스트(List<Integer> winningNumber) {
        //when, then
        Assertions.assertThatThrownBy(() -> new WinningNumber(winningNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("중복된 숫자는");
    }

    @ParameterizedTest(name = "입력 값 : {0}")
    @MethodSource("generateOutOfRangeWinningNumber")
    @DisplayName("범위를 벗어나는 당첨 번호가 입력되면 예외가 발생한다.")
    void 범위_밖_당첨번호_예외_테스트(List<Integer> winningNumber) {
        //when, then
        Assertions.assertThatThrownBy(() -> new WinningNumber(winningNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("1 ~ 45");
    }

    @ParameterizedTest(name = "당첨 번호 : {0}, 로또 번호 : {1}, 기대 값 : {2}")
    @MethodSource("generateLottoAndWinningNumber")
    @DisplayName("당첨번호와 같은 로또번호 개수를 반환한다.")
    void 당첨번호와_같은_로또번호_개수_테스트(List<Integer> lotto, List<Integer> winningNumber, int expected) {
        //given
        Lotto lottoNumber = new Lotto(lotto);
        WinningNumber winningNumbers = new WinningNumber(winningNumber);

        //when
        int actual = winningNumbers.calculateCorrectNumberCount(lottoNumber);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> generateWinningNumber() {
        return Stream.of(
                Arguments.of(List.of(1, 1, 2, 3, 4, 5)),
                Arguments.of(List.of(1, 2, 2, 3, 4, 5)),
                Arguments.of(List.of(1, 3, 3, 3, 4, 5)));
    }

    static Stream<Arguments> generateOutOfRangeWinningNumber() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 46, 47, 49, 51)),
                Arguments.of(List.of(1, 2, 122, 133, 124, 55)),
                Arguments.of(List.of(1, 3, 53, 73, 84, 95)));
    }

    static Stream<Arguments> generateLottoAndWinningNumber() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 12), 5),
                Arguments.of(List.of(1, 12, 13, 14, 15, 16), List.of(1, 13, 15, 16, 41, 45), 4),
                Arguments.of(List.of(1, 31, 32, 33, 41, 45), List.of(1, 11, 12, 13, 21, 25), 1));
    }
}
