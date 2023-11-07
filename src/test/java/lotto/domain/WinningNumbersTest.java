package lotto.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(ReplaceUnderscores.class)
class WinningNumbersTest {

    @Test
    void 당첨_번호에_중복이_존재하면_예외를_발생한다() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 5);

        // when, then
        assertThatThrownBy(() -> WinningNumbers.of(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호가_6자가_아니면_예외를_발생한다() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);

        // when, then
        assertThatThrownBy(() -> WinningNumbers.of(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호가_중복이_존재하지_않고_길이가_6이면_예외를_발생하지_않는다() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when, then
        assertThatNoException()
                .isThrownBy(() -> WinningNumbers.of(winningNumbers));
    }

    @Test
    void 당첨_번호의_범위가_올바르지_못하면_예외를_발생한다() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 46);

        // when, then
        assertThatThrownBy(() -> WinningNumbers.of(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "당첨 번호: 1, 2, 3, 4, 5, 6  / 비교 번호 : {arguments}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 당첨_번호에_입력한_값이_포함되어_있다면_true를_반환한다(int number) {
        // given
        WinningNumbers winningNumbers = WinningNumbers.of(List.of(1, 2, 3, 4, 5, 6));

        // when
        boolean result = winningNumbers.hasDuplicate(number);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void 당첨_번호에_입력한_값이_포함되어_있지_않다면_false를_반환한다() {
        // given
        WinningNumbers winningNumbers = WinningNumbers.of(List.of(1, 2, 3, 4, 5, 6));
        int number = 7;

        // when
        boolean result = winningNumbers.hasDuplicate(number);

        // then
        assertThat(result).isFalse();
    }

}
