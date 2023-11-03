package lotto.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumbersTest {

    @Test
    public void 당첨_번호가_1보다_작으면_예외가_발생한다() {
        // given
        final List<Integer> winningNumbers = List.of(0, 1, 2, 3, 4, 5);

        // then
        Assertions.assertThatThrownBy(() -> new WinningNumbers(winningNumbers, 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 당첨_번호가_45보다_크면_예외가_발생한다() {
        // given
        final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 46);

        // then
        Assertions.assertThatThrownBy(() -> new WinningNumbers(winningNumbers, 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 당첨_번호의_개수가_6개보다_작으면_예외가_발생한다() {
        // given
        final List<Integer> winningNumbers = List.of(1, 2, 3);

        // then
        Assertions.assertThatThrownBy(() -> new WinningNumbers(winningNumbers, 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 당첨_번호의_개수가_6개보다_크면_예외가_발생한다() {
        // given
        final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);

        // then
        Assertions.assertThatThrownBy(() -> new WinningNumbers(winningNumbers, 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        // given
        final List<Integer> winningNumbers = List.of(1, 1, 2, 3, 4, 5);

        // then
        Assertions.assertThatThrownBy(() -> new WinningNumbers(winningNumbers, 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        // given
        final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        final int bonus = 3;

        // then
        Assertions.assertThatThrownBy(() -> new WinningNumbers(winningNumbers, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("lottoNumbersAndMatchingNumber")
    public void 로또와_일치하는_숫자_개수_테스트(Lotto lotto, Rank rank) {
        // given
        final WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        // then
        Assertions.assertThat(winningNumbers.findRank(lotto)).isEqualTo(rank);
    }

    static Stream<Arguments> lottoNumbersAndMatchingNumber() {
        return Stream.of(
                Arguments.arguments(new Lotto(List.of(1, 2, 3, 4, 5, 6)), Rank.FIRST),
                Arguments.arguments(new Lotto(List.of(1, 2, 3, 4, 5, 7)), Rank.SECOND),
                Arguments.arguments(new Lotto(List.of(1, 2, 3, 4, 5, 8)), Rank.THIRD),
                Arguments.arguments(new Lotto(List.of(1, 2, 3, 4, 7, 8)), Rank.FOURTH),
                Arguments.arguments(new Lotto(List.of(1, 2, 3, 7, 8, 9)), Rank.FIFTH),
                Arguments.arguments(new Lotto(List.of(1, 2, 7, 8, 9, 10)), Rank.NONE),
                Arguments.arguments(new Lotto(List.of(1, 7, 8, 9, 10, 11)), Rank.NONE),
                Arguments.arguments(new Lotto(List.of(7, 8, 9, 10, 11, 12)), Rank.NONE)
        );
    }
}