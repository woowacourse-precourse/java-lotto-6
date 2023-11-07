package lotto.domain;

import java.util.HashMap;

public class Judgement {
    private HashMap<WinningRule, Integer> results = new HashMap<>();

    public Judgement() {
        results.put(WinningRule.NOTHING, 0);
        results.put(WinningRule.FIFTH_PRIZE, 0);
        results.put(WinningRule.FOURTH_PRIZE, 0);
        results.put(WinningRule.THIRD_PRIZE, 0);
        results.put(WinningRule.SECOND_PRIZE, 0);
        results.put(WinningRule.FIRST_PRIZE, 0);
    }

    public HashMap<WinningRule, Integer> getResults(Buyer buyer, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        for (Lotto lotto : buyer.getPurchaseLotteries()) {
            int matchNumbers = countMatchNumbers(lotto, winningNumbers);
            boolean matchBonusNumber = checkContainsBonusNumber(lotto, bonusNumber);
            WinningRule rank = determineRank(matchNumbers, matchBonusNumber);
            int count = results.get(rank) + 1;
            results.put(rank, count);
        }
        return results;
    }

    private int countMatchNumbers(Lotto lotto, WinningNumbers winningNumbers) {
        int matchCount = 0;
        for (int number : winningNumbers.getWinningNumbers()) {
            if (lotto.getNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean checkContainsBonusNumber(Lotto lotto, BonusNumber bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    private WinningRule determineRank(int matchNumbers, boolean matchBonusNumber) {
        if (matchNumbers == 6) {
            return WinningRule.FIRST_PRIZE;
        }
        if (matchNumbers == 5 && matchBonusNumber) {
            return WinningRule.SECOND_PRIZE;
        }
        if (matchNumbers == 5) {
            return WinningRule.THIRD_PRIZE;
        }
        if (matchNumbers == 4) {
            return WinningRule.FOURTH_PRIZE;
        }
        if (matchNumbers == 3) {
            return WinningRule.FIFTH_PRIZE;
        }
        return WinningRule.NOTHING;
    }
}
