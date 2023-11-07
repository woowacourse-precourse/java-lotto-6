package lotto.service;

import static lotto.message.MessageFormat.FIVE_MATCH;
import static lotto.message.MessageFormat.FIVE_MATCH_WITH_BONUS;
import static lotto.message.MessageFormat.FOUR_MATCH;
import static lotto.message.MessageFormat.SIX_MATCH;
import static lotto.message.MessageFormat.THREE_MATCH;

import java.util.HashMap;
import lotto.domain.WinningList;

public class CalculationService {

    public int getBuyLottoCount(int purchasePrice) {
        return purchasePrice / 1000;
    }
    public Double getYields(int consumption, int profit) {
        return ((double) profit  / consumption) * 100;
    }

    public int getProfit (WinningList winningList) {
        int profit = 0;
        profit += winningList.getWinningCount(3) * THREE_MATCH.getAmount();
        profit += winningList.getWinningCount(4) * FOUR_MATCH.getAmount();
        profit += winningList.getWinningCount(5) * FIVE_MATCH.getAmount();
        profit += winningList.getWinningCount(9) * FIVE_MATCH_WITH_BONUS.getAmount();
        profit += winningList.getWinningCount(6) * SIX_MATCH.getAmount();

        return profit;
    }
}
