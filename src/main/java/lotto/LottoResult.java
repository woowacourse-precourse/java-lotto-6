package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private int[] rankCount;
    private double rateOfReturn;

    public LottoResult() {
        rankCount = new int[5];
        rateOfReturn = 0;
    }

    public void calculateRateOfReturn(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber, int money) {
        int profit = totalProfit(lottos, winningNumbers, bonusNumber);
        rateOfReturn = ((double) profit / money) * 100;     // 수익률(%) = (순투자수익/투자 비용) * 100%
    }

    private int totalProfit(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
        int profit = 0;
        for (Lotto lotto : lottos) {
            int matchedNumbers = getMatchedNumber(lotto, winningNumbers);
            boolean matchedBonus = isMatchedBonusNumber(lotto, bonusNumber);
            profit += eachProfit(matchedNumbers, matchedBonus);
        }
        return profit;
    }

    private int eachProfit(int matchedNumbers, boolean matchedBonus) {
        for (Rank rank : Rank.values()) {
            if (rank.getMatchedNumbers() == matchedNumbers && (!rank.isBonusMatch() || matchedBonus)) {
                return rank.getProfit();
            }
        }
        return 0;
    }

    public void totalRanking(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            int matchedNumbers = getMatchedNumber(lotto, winningNumbers);
            boolean matchedBonus = isMatchedBonusNumber(lotto, bonusNumber);
            eachRankCounting(matchedNumbers, matchedBonus);
        }
    }

    private void eachRankCounting(int matchedNumbers, boolean matchedBonus) {
        for (Rank rank : Rank.values()) {
            if (rank.getMatchedNumbers() == matchedNumbers && (!rank.isBonusMatch() || matchedBonus)) {
                rankCount[rank.ordinal()]++;
            }
        }
    }

    private int getMatchedNumber(Lotto lotto, Lotto winningNumbers) {
        int matchedCount = 0;
        for (int j = 0; j < 6; j++) {
            if (lotto.contains(winningNumbers.getNumbers().get(j)))
                matchedCount++;
        }
        return matchedCount;
    }

    private boolean isMatchedBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.contains(bonusNumber);
    }

    public String toString() {
        List<String> resultDescription = new ArrayList<>();
        for (int i = Rank.values().length - 1; i >= 0; i--) {
            Rank rank = Rank.values()[i];
            resultDescription.add(rank.getDescription() + " - " + rankCount[rank.ordinal()] + "개");
        }
        resultDescription.add("총 수익률은 " + Math.round(rateOfReturn * 10.0) / 10.0 + "%입니다.");
        return String.join("\n", resultDescription);
    }
}
