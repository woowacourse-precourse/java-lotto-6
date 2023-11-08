package lotto.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoRankManagerTest {
    @Test
    void 로또_당첨_결과를_판단한다() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 14, 15, 16));
        Bonus bonus = new Bonus(7);
        WinningNumbers winningNumbers = new WinningNumbers(lotto, bonus);

        LottoRank result = LottoRankManager.findLottoRanks(lottos, winningNumbers).get(0);
        Assertions.assertThat(result).isEqualTo(LottoRank.FIFTH);
    }
}