package study.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    void validate_범위가_아닌_수가_있는경우() {
        assertThatThrownBy(
                () -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 46)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void validate_중복된_수가_있는경우() {
        assertThatThrownBy(
                () -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void contains() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        assertTrue(winningLotto.contains(1));
        assertThat(winningLotto.getBonusNumber()).isEqualTo(7);
    }
}
