package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("올바른 입력시 예외가 발생하지 않는다 (1 ~ 45 사이의 6개 중복없는 숫자 배열)")
    @Test
    public void 올바른_입력시_예외가_발생하지_않는다() {
        // given
        List<Integer> lotto = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        // when
        Lotto lotto1 = new Lotto(lotto);
        // then
        assertThat(lotto).isEqualTo(lotto1.getNumbers());
    }

    @DisplayName("길이가 맞지 않으면 예외가 발생한다.")
    @Test
    public void 길이가_맞지_않으면_예외가_발생한다() {
        List<Integer> lotto = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        assertThatThrownBy(() -> new Lotto(lotto)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.isNotMatchLottoLength());
    }

    @DisplayName("범위에 있지않은 숫자가 있으면 예외가 발생한다")
    @Test
    public void 범위에_있지않은_숫자가_있으면_예외가_발생한다() {
        List<Integer> lotto = new ArrayList<>(List.of(1, 2, 3, 4, 5, 101));
        assertThatThrownBy(() -> new Lotto(lotto)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.isNotInRange());
    }

    @DisplayName("중복되는 숫자가 있으면 예외가 발생한다")
    @Test
    public void 중복되는_숫자가_있으면_예외가_발생한다() {
        List<Integer> lotto = new ArrayList<>(List.of(1, 2, 3, 4, 5, 5));
        assertThatThrownBy(() -> new Lotto(lotto)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.isDuplicatedLotto());
    }
}