package lotto.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

public class LottoResult {
    private static final int MATCH_COUNT_FOR_BONUS_CHECK = 5;
    private Map<WinningStrategy, Integer> numberMatchResult;

    public LottoResult(PurchasedLottos purchasedLottos, LotteryNumbers lotteryNumbers) {
        calculateWinningResults(purchasedLottos, lotteryNumbers);
    }

    public void calculateWinningResults(PurchasedLottos purchasedLottos, LotteryNumbers lotteryNumbers) {
        this.numberMatchResult = new HashMap<>();

        purchasedLottos.forEach(lotto -> {
            int matchCount = getMatchCount(lotto, lotteryNumbers);
            boolean bonusMatchResult = checkBonusNumber(matchCount, lotto, lotteryNumbers.getBonusNumber());

            Optional<WinningStrategy> strategyOptional = WinningStrategy.find(matchCount, bonusMatchResult);
            strategyOptional.ifPresent(winningStrategy -> {
                numberMatchResult.put(winningStrategy, numberMatchResult.getOrDefault(winningStrategy, 0) + 1);
            });
        });
    }

    public int getMatchCount(Lotto lotto, LotteryNumbers lotteryNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(number -> lotteryNumbers.getWinningNumbers().stream()
                        .anyMatch(Predicate.isEqual(number))).count();
    }

    private boolean checkBonusNumber(int matchCount, Lotto lotto, int bonusNumber) {
        if (matchCountRequiresBonusCheck(matchCount)) {
            return lotto.getNumbers().contains(bonusNumber);
        }
        return false;
    }

    public boolean matchCountRequiresBonusCheck(int matchCount) {
        return matchCount == MATCH_COUNT_FOR_BONUS_CHECK;
    }

    public Map<WinningStrategy, Integer> getNumberMatchResult() {
        return numberMatchResult;
    }
}
