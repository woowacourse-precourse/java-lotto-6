package lotto;


import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {
    @Test
    @DisplayName("로또 순위 결정 테스트")
    void calculateWinning() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 10, 11));
        Lotto lotto5 = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        Lotto lotto6 = new Lotto(List.of(1, 2, 40, 41, 42, 43));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        Result result = new Result();
        result.calculateWinning(lottos, winningLotto);

        assertThat(result.getResult()).containsEntry(Rank.FIRST, 1);
        assertThat(result.getResult()).containsEntry(Rank.SECOND, 1);
        assertThat(result.getResult()).containsEntry(Rank.THIRD, 1);
        assertThat(result.getResult()).containsEntry(Rank.FOURTH, 1);
        assertThat(result.getResult()).containsEntry(Rank.FIFTH, 1);
        assertThat(result.getResult()).containsEntry(Rank.NONE, 1);
    }
}
