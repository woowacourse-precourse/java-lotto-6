package lotto.domain;

import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoManagerTest {

    private final Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
    private final int bonusNumber = 7;
    private final LottoManager lottoManager = new LottoManager(winningLotto, bonusNumber);

    private final List<Lotto> lottos = List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(1, 2, 3, 4, 5, 7)),
            new Lotto(List.of(1, 2, 3, 4, 5, 7)),
            new Lotto(List.of(1, 2, 3, 4, 5, 8))
    );

    @DisplayName("로또들에 대한 등수와 로또들이 몇 등에 몇 개 당첨 됐는지 알 수 있다.")
    @Test
    void checkLottoRanks() {
        Map<Rank,Integer> ranks = lottoManager.getLottosRanks(lottos);

        Assertions.assertThat(ranks.get(Rank.FIRST)).isEqualTo(1);
        Assertions.assertThat(ranks.get(Rank.SECOND)).isEqualTo(2);
        Assertions.assertThat(ranks.get(Rank.THIRD)).isEqualTo(1);
    }

}
