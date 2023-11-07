package lotto.data;

import static lotto.message.ErrorMessage.LOTTO_IS_NOT_SIX_DIGITS;
import static lotto.message.ErrorMessage.LOTTO_NUMBER_IS_DUPLICATED;
import static lotto.message.ErrorMessage.LOTTO_NUMBER_IS_NOT_IN_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.data.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {
    @ParameterizedTest
    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @MethodSource("provideNotSixDigitsLottos")
    void createLottoByOverSize(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_IS_NOT_SIX_DIGITS.getMessage());
    }

    @ParameterizedTest
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @MethodSource("provideDuplicatedLottos")
    void createLottoByDuplicatedNumber(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_IS_DUPLICATED.getMessage());
    }

    @DisplayName("로또 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByNumberNotInCorrectRange() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_IS_NOT_IN_RANGE.getMessage());
    }

    @ParameterizedTest
    @DisplayName("로또 번호를 정렬하여 보여준다.")
    @MethodSource("provideValidateSortedLottoSets")
    void createLottoBySortedNumbers(List<Integer> numbers, String expected) {
        assertThat(new Lotto(numbers).toString())
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("해당 로또와 당첨 번호의 일치 개수를 계산한다.")
    @MethodSource("provideMatchCountSets")
    void getMatchCountWithWinningNumbers(List<Integer> numbers, List<Integer> winningNumbers, int expected) {
        Lotto given = new Lotto(numbers);

        assertThat(given.getMatchCountWith(winningNumbers))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> provideNotSixDigitsLottos() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(List.of(1, 2, 3, 4, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7, 8))
        );
    }

    private static Stream<Arguments> provideDuplicatedLottos() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 1)),
                Arguments.of(List.of(1, 2, 3, 3, 3, 2))
        );
    }

    private static Stream<Arguments> provideValidateSortedLottoSets() {
        return Stream.of(
                Arguments.of(List.of(3, 4, 5, 2, 1, 6), List.of(1, 2, 3, 4, 5, 6).toString()),
                Arguments.of(List.of(23, 44, 34, 45, 12, 9), List.of(9, 12, 23, 34, 44, 45).toString()),
                Arguments.of(List.of(23, 41, 32, 12, 31, 42), List.of(12, 23, 31, 32, 41, 42).toString())
        );
    }

    private static Stream<Arguments> provideMatchCountSets() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(List.of(1, 20, 30, 40, 5, 6), List.of(1, 2, 3, 4, 5, 6), 3),
                Arguments.of(List.of(10, 20, 30, 40, 41, 42), List.of(1, 2, 3, 4, 5, 6), 0)
        );
    }

}