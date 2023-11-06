package lotto;

import lotto.model.BonusNumber;
import lotto.model.Calculate;
import lotto.model.Lotto;
import lotto.model.MatchingCount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WinningStatisticTest {

    Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    BonusNumber bonusNumber = new BonusNumber("7",winningNumbers);
    MatchingCount matchingCount = new MatchingCount();

    Lotto sixMatchingLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    Lotto bonusMatchingLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
    Lotto threeMatchingLotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));

    @DisplayName("당첨번호와 일치하는 개수에 따라 matchingCounts 업데이트되어야 한다.")
    @Test
    void confirmLottoMatchingWinningNumbers() {
        matchingCount.updateMatchingCounts(sixMatchingLotto, winningNumbers, bonusNumber);
        Assertions.assertEquals(matchingCount.getMatchingCounts(), List.of(0,0,0,0,1));

        matchingCount.updateMatchingCounts(bonusMatchingLotto, winningNumbers, bonusNumber);
        Assertions.assertEquals(matchingCount.getMatchingCounts(), List.of(0,0,0,1,1));

        matchingCount.updateMatchingCounts(threeMatchingLotto, winningNumbers, bonusNumber);
        Assertions.assertEquals(matchingCount.getMatchingCounts(), List.of(1,0,0,1,1));
    }

    @DisplayName("총 당첨금을 확인한다.")
    @Test
    void confirmTotalProfit(){
        updateMatchingCount();
        double totalProfit = Calculate.totalProfit(matchingCount.getMatchingCounts());
        Assertions.assertEquals(totalProfit,2_030_005_000);
    }

    @DisplayName("총 수익률을 확인한다.")
    @Test
    void confirmTotalReturn(){
        updateMatchingCount();
        double totalProfit = Calculate.totalProfit(matchingCount.getMatchingCounts());
        String totalReturn = Calculate.totalReturnRate(totalProfit, 3000);
        Assertions.assertEquals(totalReturn,"67,666,833.3");
    }

    void updateMatchingCount(){
        matchingCount.updateMatchingCounts(sixMatchingLotto, winningNumbers, bonusNumber);
        matchingCount.updateMatchingCounts(bonusMatchingLotto, winningNumbers, bonusNumber);
        matchingCount.updateMatchingCounts(threeMatchingLotto, winningNumbers, bonusNumber);
    }

}
