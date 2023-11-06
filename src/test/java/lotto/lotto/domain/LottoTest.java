package lotto.lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.Rank;
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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 1등 당첨 결과를 출력해야 한다.")
    @Test
    void matchLottoFirst() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Rank rank = lotto.match(List.of(1, 2, 3, 4, 5, 6), 7);

        Assertions.assertEquals(rank, Rank.FIRST);
    }

    @DisplayName("로또 2등 당첨 결과를 출력해야 한다.")
    @Test
    void matchLottoSecond() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Rank rank = lotto.match(List.of(11, 2, 3, 4, 5, 6), 1);

        Assertions.assertEquals(rank, Rank.SECOND);
    }

    @DisplayName("로또 3등 당첨 결과를 출력해야 한다.")
    @Test
    void matchLottoThird() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Rank rank = lotto.match(List.of(11, 2, 3, 4, 5, 6), 7);

        Assertions.assertEquals(rank, Rank.THIRD);
    }

    @DisplayName("로또 4등 당첨 결과를 출력해야 한다.")
    @Test
    void matchLottoFourth() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Rank rank = lotto.match(List.of(11, 12, 3, 4, 5, 6), 7);

        Assertions.assertEquals(rank, Rank.FOURTH);
    }

    @DisplayName("로또 5등 당첨 결과를 출력해야 한다.")
    @Test
    void matchLottoFifth() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Rank rank = lotto.match(List.of(11, 12, 13, 4, 5, 6), 7);

        Assertions.assertEquals(rank, Rank.FIFTH);
    }

    @DisplayName("로또 낙첨 결과를 출력해야 한다.")
    @Test
    void matchLottoMiss() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Rank rank = lotto.match(List.of(11, 12, 13, 14, 15, 16), 7);

        Assertions.assertEquals(rank, Rank.MISS);
    }
}