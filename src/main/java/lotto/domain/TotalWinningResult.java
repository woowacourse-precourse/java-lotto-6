package lotto.domain;

import java.util.HashMap;

public class TotalWinningResult {
    private HashMap<LottoPrize, Integer> prizeResult;
    private double totalPrizeMoney;

    public TotalWinningResult() {
        prizeResult = new HashMap<>();
        for(LottoPrize lottoPrize : LottoPrize.values()) {
            prizeResult.put(lottoPrize, 0);
        }

        totalPrizeMoney = 0.0;
    }

    public HashMap<LottoPrize, Integer> getPrizeResult() {
        return prizeResult;
    }

    public void calculateToTalRanks(Lottos lottos, Lotto winningNumbers, BonusNumber bonusNumber) {
        for(Lotto lotto : lottos.getLottos()) {
            int matchNumbers = getMatchNumbers(lotto, winningNumbers);
            boolean isMatchBonus = isMatchBonusNumber(lotto, bonusNumber.getBonusNumber());
            LottoPrize lottoPrize = LottoPrize.getPrizeRank(matchNumbers, isMatchBonus);
            addPrizeResult(lottoPrize);
            addTotalPrizeMoney(lottoPrize);
        }
    }

    public String calculateRateOfReturn(int amount) {
        double rate = (totalPrizeMoney / amount) * 100;
        return String.format("%.1f", rate);
    }

    private void addPrizeResult(LottoPrize lottoPrize) {
        prizeResult.put(lottoPrize, prizeResult.get(lottoPrize)+1);
    }

    private void addTotalPrizeMoney(LottoPrize lottoPrize) {
        totalPrizeMoney += lottoPrize.getPrizeMoney();
    }

    private boolean isMatchBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private int getMatchNumbers(Lotto lotto, Lotto winningNumbers) {
        int matchCount = 0;
        for(int number : lotto.getNumbers()) {
            if(winningNumbers.getNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

}
