package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능

    @Test
    public void 로또_번호가_입력받는_숫자를_포함하고_있으면_true를_반환한다() {
        // given
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        final Lotto lotto = new Lotto(numbers);

        // then
        Assertions.assertTrue(lotto.contains(5));
    }

    @Test
    public void 로또_번호가_입력받는_숫자를_포함하고_있지_않으면면_false를_반환한다() {
        // given
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        final Lotto lotto = new Lotto(numbers);

        // then
        assertFalse(lotto.contains(7));
    }

    @Test
    public void 당첨_번호가_1보다_작으면_예외가_발생한다() {
        // given
        final List<Integer> winningNumbers = List.of(0, 1, 2, 3, 4, 5);

        // then
        assertThatThrownBy(() -> new Lotto(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 당첨_번호가_45보다_크면_예외가_발생한다() {
        // given
        final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 46);

        // then
        assertThatThrownBy(() -> new Lotto(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 당첨_번호의_개수가_6개보다_작으면_예외가_발생한다() {
        // given
        final List<Integer> winningNumbers = List.of(1, 2, 3);

        // then
        assertThatThrownBy(() -> new Lotto(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 당첨_번호의_개수가_6개보다_크면_예외가_발생한다() {
        // given
        final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);

        // then
        assertThatThrownBy(() -> new Lotto(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        // given
        final List<Integer> winningNumbers = List.of(1, 1, 2, 3, 4, 5);

        // then
        assertThatThrownBy(() -> new Lotto(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 당첨_번호에_포함된_숫자이면_true를_반환한다() {
        // given
        final Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // then
        org.junit.jupiter.api.Assertions.assertTrue(winningNumbers.contains(2));
    }

    @Test
    public void 당첨_번호에_포함되지_않은_숫자이면_false를_반환한다() {
        // given
        final Lotto winningNumbersData = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // then
        assertFalse(winningNumbersData.contains(7));
    }

    @Test
    public void 당첨_번호와_로또_번호의_일치하는_숫자의_개수_테스트() {
        // given
        final Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final Lotto lotto = new Lotto(List.of(1, 2, 4, 7, 8, 9));

        // when
        int matchingNumber = winningNumbers.countNumber(lotto);

        // then
        assertEquals(matchingNumber, 3);
    }
}