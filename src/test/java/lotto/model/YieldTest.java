package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Test;

class YieldTest {

    @Test
    void 수익률_계산() {
        MatchLotto matchLotto = new MatchLotto();
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Lotto> purchaseHistory = new ArrayList<>();
        purchaseHistory.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        purchaseHistory.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        purchaseHistory.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        purchaseHistory.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        purchaseHistory.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
        purchaseHistory.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
        purchaseHistory.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
        purchaseHistory.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));

        matchLotto.matchLotto(winningNumbers, bonusNumber, purchaseHistory);
        HashMap<LottoRankings, Integer> lottoResult = LottoResult.createLottoResult()
                .checkResult(matchLotto.getMatchResult());

        String yield = Yield.createYield()
                .calculateYield(8000, lottoResult);

        assertThat(yield).isEqualTo("62.5");
    }
}