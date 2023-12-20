package lotto.domain;

import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RankTest {

    @Test
    void secondRankTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningLotto winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                7
        );
        Assertions.assertThat(Rank.sortRank(lotto, winningLotto).get())
                .isEqualTo(SECOND);
    }

    @Test
    void thirdRankTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningLotto winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                8
        );
        Assertions.assertThat(Rank.sortRank(lotto, winningLotto).get())
                .isEqualTo(THIRD);
    }
}
