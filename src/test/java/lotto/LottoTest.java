package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        Assertions.assertTrue(lotto.hasNumber(5));
    }

    @Test
    public void 로또_번호가_입력받는_숫자를_포함하고_있지_않으면면_false를_반환한다() {
        // given
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        final Lotto lotto = new Lotto(numbers);

        // then
        Assertions.assertFalse(lotto.hasNumber(7));
    }
}