package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RankCalculatorTest {
    private final RankCalculator rankCalculator = new RankCalculator();

    @DisplayName("구매한 로또들과 당첨 번호, 보너스 번호를 비교하여 순위를 계산한다.")
    @Test
    void calculateRankByComparingPurchasedLottoWithWinningAndBonusNumbers() {
        int bonusNumber = 7;
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> purchasedLotto = makePurchasedLotto();
        List<Rank> ranks = rankCalculator.calculateAllRanks(purchasedLotto, winningLotto, bonusNumber);

        assertThat(ranks).contains(Rank.values());
    }

    private List<Lotto> makePurchasedLotto() {
        return List.of(
                new Lotto(List.of(10, 20, 30, 40, 45, 6)),
                new Lotto(List.of(10, 20, 30, 4, 5, 6)),
                new Lotto(List.of(10, 20, 3, 4, 5, 6)),
                new Lotto(List.of(10, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7))
        );
    }
}