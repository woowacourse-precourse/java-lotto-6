package study.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.enums.LottoPrize;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    void validate_길이가_6이_아닌경우() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validate_범위가_아닌_수가_있는경우() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validate_중복된_수가_있는경우() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void contains() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertTrue(lotto.contains(1));
        assertFalse(lotto.contains(7));
    }

    @Test
    void checkPrize_first_place() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        LottoPrize lottoPrize = lotto.checkPrize(winningLotto);

        assertThat(lottoPrize).isEqualTo(LottoPrize.FIRST_PLACE);
    }

    @Test
    void checkPrize_second_place() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 7)), 6);

        LottoPrize lottoPrize = lotto.checkPrize(winningLotto);

        assertThat(lottoPrize).isEqualTo(LottoPrize.SECOND_PLACE);
    }

    @Test
    void checkPrize_third_place() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 7)), 8);

        LottoPrize lottoPrize = lotto.checkPrize(winningLotto);

        assertThat(lottoPrize).isEqualTo(LottoPrize.THIRD_PLACE);
    }

    @Test
    void checkPrize_forth_place() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 7, 8)), 6);

        LottoPrize lottoPrize = lotto.checkPrize(winningLotto);

        assertThat(lottoPrize).isEqualTo(LottoPrize.FORTH_PLACE);
    }

    @Test
    void checkPrize_fifth_place() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 7, 8, 9)), 6);

        LottoPrize lottoPrize = lotto.checkPrize(winningLotto);

        assertThat(lottoPrize).isEqualTo(LottoPrize.FIFTH_PLACE);
    }

    @Test
    void checkPrize_no_place() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 7, 8, 9, 10)), 6);

        LottoPrize lottoPrize = lotto.checkPrize(winningLotto);

        assertThat(lottoPrize).isEqualTo(LottoPrize.NO_PLACE);
    }
}
