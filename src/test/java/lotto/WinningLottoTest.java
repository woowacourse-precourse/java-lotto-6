package lotto;

import lotto.util.Constants;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @Test
    void getBonusNum() {
        assertThatThrownBy(() -> {
            new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 2);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.ERROR_LOTTO_DUPLICATE_NUMBER);
    }

    @Test
    void getBonusNum2() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 34);

        assertThat(winningLotto.getNumbers()).contains(1, 2, 3, 4, 5, 6);
        assertThat(winningLotto.getBonusNum()).isEqualTo(34);

    }

    @Test
    void getBonusNum3() {
        assertThatThrownBy(() -> {
            new WinningLotto(List.of(1, 2, 3, 47, 5, 6), 34);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.ERROR_LOTTO_NUMBER_RANGE);
    }
}