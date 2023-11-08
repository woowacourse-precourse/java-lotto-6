package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("6개의 숫자로 이루어진 로또 번호를 입력해 주세요.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 번호는 중복될 수 없습니다.");
    }

    @DisplayName("로또 번호가 1~45 사이가 아니라면 예외가 발생한다.")
    @Test
    void createLottoByInvalidRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 50)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 번호는 1 이상 45 이하여야 합니다.");
    }

    @DisplayName("정수 리스트를 통해 생성할 수 있다.")
    @Test
    void createLottoByIntegerList() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        Lotto lotto = new Lotto(numbers);

        // then
        assertThat(lotto).isInstanceOf(Lotto.class);
        assertThat(lotto.getNumbers()).contains(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("로또 번호가 포함되어있는지 확인할 수 있다.")
    @ParameterizedTest(name = "[{index}] : number = {0}, expected = {1}")
    @CsvSource(value = {"1, true", "2, true", "7, false", "10, false"})
    void checkLottoNumberContains(final int number, final boolean expected) {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        boolean result = lotto.contains(number);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("로또 번호가 몇 개 포함되어있는지 계산할 수 있다.")
    @ParameterizedTest(name = "[{index}] : compare = {0}, control = {1}, expected = {2}")
    @MethodSource("lottoMatchArgument")
    void countMatchLottoNumbers(final List<Integer> compareNumbers,
                                final List<Integer> controlNumbers,
                                final int expected) {
        // given
        Lotto compareLotto = new Lotto(compareNumbers);
        Lotto controlLotto = new Lotto(controlNumbers);

        // when
        int result = compareLotto.countMatches(controlLotto);

        // then
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> lottoMatchArgument() {
        return Stream.of(
            Arguments.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(11, 12, 13, 14, 15, 16),
                0
            ),
            Arguments.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 12, 13, 14, 15, 16),
                1
            ),
            Arguments.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 13, 14, 15, 16),
                2
            ),
            Arguments.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 14, 15, 16),
                3
            ),
            Arguments.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 15, 16),
                4
            ),
            Arguments.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 16),
                5
            ),
            Arguments.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                6
            )
        );
    }
}