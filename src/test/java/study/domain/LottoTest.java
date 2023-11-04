package study.domain;

import static lotto.domain.LottoPrize.FIRST_PLACE;
import static lotto.domain.LottoPrize.FIFTH_PLACE;
import static lotto.domain.LottoPrize.FORTH_PLACE;
import static lotto.domain.LottoPrize.NO_PLACE;
import static lotto.domain.LottoPrize.SECOND_PLACE;
import static lotto.domain.LottoPrize.THIRD_PLACE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
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
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        LottoPrize lottoPrize = lotto.checkPrize(winningLotto, bonusNumber);

        assertThat(lottoPrize).isEqualTo(FIRST_PLACE);
    }

    @Test
    void checkPrize_second_place() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        int bonusNumber = 6;

        LottoPrize lottoPrize = lotto.checkPrize(winningLotto, bonusNumber);

        assertThat(lottoPrize).isEqualTo(SECOND_PLACE);
    }

    @Test
    void checkPrize_third_place() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        int bonusNumber = 8;

        LottoPrize lottoPrize = lotto.checkPrize(winningLotto, bonusNumber);

        assertThat(lottoPrize).isEqualTo(THIRD_PLACE);
    }

    @Test
    void checkPrize_forth_place() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        int bonusNumber = 6;

        LottoPrize lottoPrize = lotto.checkPrize(winningLotto, bonusNumber);

        assertThat(lottoPrize).isEqualTo(FORTH_PLACE);
    }

    @Test
    void checkPrize_fifth_place() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        int bonusNumber = 6;

        LottoPrize lottoPrize = lotto.checkPrize(winningLotto, bonusNumber);

        assertThat(lottoPrize).isEqualTo(FIFTH_PLACE);
    }

    @Test
    void checkPrize_no_place() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 7, 8, 9, 10));
        int bonusNumber = 6;

        LottoPrize lottoPrize = lotto.checkPrize(winningLotto, bonusNumber);

        assertThat(lottoPrize).isEqualTo(NO_PLACE);
    }
}
