package lotto.model;


import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void 등수_확인() {
        MatchLotto matchLotto = new MatchLotto();
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Lotto> purchaseHistory = new ArrayList<>();
        purchaseHistory.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        purchaseHistory.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        purchaseHistory.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        purchaseHistory.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        purchaseHistory.add(new Lotto(List.of(1, 2, 3, 4, 7, 8)));

        matchLotto.matchLotto(winningNumbers, bonusNumber, purchaseHistory);
        HashMap<LottoRankings, Integer> lottoResult = LottoResult.createLottoResult()
                .checkResult(matchLotto.getMatchResult());

        assertThat(lottoResult.get(LottoRankings.FIRST)).isEqualTo(2);
        assertThat(lottoResult.get(LottoRankings.SECOND)).isEqualTo(1);
        assertThat(lottoResult.get(LottoRankings.THIRD)).isEqualTo(1);
        assertThat(lottoResult.get(LottoRankings.FOURTH)).isEqualTo(1);
    }
}