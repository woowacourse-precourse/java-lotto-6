package lotto.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningNumbersDataTest {

    @Test
    public void 당첨_번호가_1보다_작으면_예외가_발생한다() {
        // given
        final List<Integer> winningNumbers = List.of(0, 1, 2, 3, 4, 5);

        // then
        Assertions.assertThatThrownBy(() -> new WinningNumbersData(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 당첨_번호가_45보다_크면_예외가_발생한다() {
        // given
        final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 46);

        // then
        Assertions.assertThatThrownBy(() -> new WinningNumbersData(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 당첨_번호의_개수가_6개보다_작으면_예외가_발생한다() {
        // given
        final List<Integer> winningNumbers = List.of(1, 2, 3);

        // then
        Assertions.assertThatThrownBy(() -> new WinningNumbersData(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 당첨_번호의_개수가_6개보다_크면_예외가_발생한다() {
        // given
        final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);

        // then
        Assertions.assertThatThrownBy(() -> new WinningNumbersData(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        // given
        final List<Integer> winningNumbers = List.of(1, 1, 2, 3, 4, 5);

        // then
        Assertions.assertThatThrownBy(() -> new WinningNumbersData(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}