package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import lotto.view.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    List<Integer> winning;

    @BeforeEach
    void beforeEach() {
        winning = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("제대로 입력하면 예외가 발생하지 않는다.")
    @Test
    public void 제대로_입력하면_예외가_발생하지_않는다() {
        // given
        String bonus = "7";

        // then
        assertDoesNotThrow(() -> new WinningLotto(winning, bonus));
    }
    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다")
    @Test
    public void 보너스_번호가_숫자가_아니면_예외가_발생한다() {
        // given
        String bonus = "a";

        // then
        assertThatThrownBy(() -> new WinningLotto(winning, bonus)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.isNotNumber());
    }

    @DisplayName("자연수가 아니면 예외가 발생한다")
    @Test
    public void 자연수가_아니면_예외가_발생한다() {
        String bonus = "0";
        assertThatThrownBy(() -> new WinningLotto(winning, bonus)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.isNotNatural());
    }
}