package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.constants.RankMessage;

public class LottoResult {
    private static final int CHECK_FOR_SECOND_PRIZE = 5;
    private static final int DEFALUT= 0;
    private static final int ADD_AMOUNT = 1;

    private final Map<RankMessage, Integer> winningResult = new EnumMap<>(RankMessage.class);

    public void calculateRankingResult(List<Lotto> lottos, Numbers numbers) {
        Lotto winningNumbers = numbers.getWinningNumbers();
        int bonusNumber = numbers.getBonusNumber();

        for (Lotto lotto : lottos) {
            updateRankingResult(lotto, winningNumbers, bonusNumber);
        }
    }

    public double getProfitRate(LottoPurchase lottoPurchase) {
        long totalPrizeMoney = Calculation.calculateTotalPrizeMoney(winningResult);
        int purchaseAmount = lottoPurchase.getAmount();
        return Calculation.calculateProfitRate(totalPrizeMoney, purchaseAmount);
    }

    public LottoResult() {
        RankMessage[] rankings = RankMessage.values();
        for (RankMessage ranking : rankings) {
            winningResult.put(ranking, DEFALUT);
        }
    }

    private void updateRankingResult(Lotto lotto, Lotto winningNumbers, int bonusNumber) {
        int matchCount = lotto.countMatchingNumber(winningNumbers);

        if (matchCount == CHECK_FOR_SECOND_PRIZE) {
            executeBonus(lotto, bonusNumber);
            return;
        }
        updateExceptBonus(matchCount);
    }
    private void updateExceptBonus(int matchCount) {
        RankMessage[] rankings = RankMessage.values();
        for (RankMessage ranking : rankings) {
            addRankingCount(ranking, matchCount);
        }
    }
    public void executeBonus(Lotto lotto, int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            winningResult.put(RankMessage.SECOND, winningResult.get(RankMessage.SECOND) + ADD_AMOUNT);
        }
    }
    public void addRankingCount(RankMessage ranking, int matchCount) {
        if (ranking.getMatchCount() == matchCount) {
            winningResult.put(ranking, winningResult.get(ranking) + ADD_AMOUNT);
        }
    }
    public Map<RankMessage, Integer> getWinningResult() {
        return winningResult;
    }
}
