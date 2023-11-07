package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.*;


class WinningLottoTest {

    @Test
    void Bonus_범위를_벗어나는_수() {
        assertThatThrownBy(() -> new WinningLotto(asList(1, 2, 3, 4, 5, 6), "0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void Bonus_중복되는_수() {
        assertThatThrownBy(() -> new WinningLotto(asList(1, 2, 3, 4, 5, 6), "1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void Bonus_숫자가_아닌_수() {
        assertThatThrownBy(() -> new WinningLotto(asList(1, 2, 3, 4, 5, 6), "24j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}