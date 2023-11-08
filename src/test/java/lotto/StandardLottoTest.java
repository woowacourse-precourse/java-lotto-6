package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StandardLottoTest {
    private StandardLotto standardLotto;
    @BeforeEach
    void init() {
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        standardLotto = new StandardLotto(userLotto, bonusNumber);
    }

    @Test
    void matchPrize_FIRST() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Prize prize = standardLotto.matchPrize(lotto);
        assertThat(prize).isEqualTo(Prize.FIRST);
    }

    @Test
    void matchPrize_SECOND() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,7,8));
        Prize prize = standardLotto.matchPrize(lotto);
        assertThat(prize).isEqualTo(Prize.SECOND);
    }

    @Test
    void matchPrize_THIRD() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,8));
        Prize prize = standardLotto.matchPrize(lotto);
        assertThat(prize).isEqualTo(Prize.THIRD);
    }

    @Test
    void matchPrize_FOURTH() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,9,8));
        Prize prize = standardLotto.matchPrize(lotto);
        assertThat(prize).isEqualTo(Prize.FOURTH);
    }

    @Test
    void matchPrize_FIFTH() {
        Lotto lotto = new Lotto(List.of(1,2,3,10,9,8));
        Prize prize = standardLotto.matchPrize(lotto);
        assertThat(prize).isEqualTo(Prize.FIFTH);
    }

    @Test
    void matchPrize_NONE() {
        Lotto lotto = new Lotto(List.of(7,8,9,10,11,12));
        Prize prize = standardLotto.matchPrize(lotto);
        assertThat(prize).isEqualTo(Prize.NONE);
    }
}