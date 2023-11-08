package lotto.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

public class LottoResult {
    private static final int MATCH_COUNT_FOR_BONUS_CHECK = 5;
    private Map<WinningCriteria, Integer> numberMatchResult;

    public LottoResult(Lottos lottos, LotteryNumbers lotteryNumbers) {
        calculateWinningResults(lottos, lotteryNumbers);
    }

    private void calculateWinningResults(Lottos lottos, LotteryNumbers lotteryNumbers) {
        this.numberMatchResult = new HashMap<>();

        lottos.forEach(lotto -> {
            int matchCount = getMatchCount(lotto, lotteryNumbers);
            boolean bonusMatchResult = checkBonusNumber(matchCount, lotto, lotteryNumbers.getBonusNumber());

            Optional<WinningCriteria> criteriaOptional = WinningCriteria.find(matchCount, bonusMatchResult);
            criteriaOptional.ifPresent(criteria -> {
                numberMatchResult.put(criteria, numberMatchResult.getOrDefault(criteria, 0) + 1);
            });
        });
    }

    private int getMatchCount(Lotto lotto, LotteryNumbers lotteryNumbers) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(number -> lotteryNumbers.getWinningNumbers().stream().anyMatch(Predicate.isEqual(number)))
                .count();
    }

    private boolean checkBonusNumber(int matchCount, Lotto lotto, int bonusNumber) {
        if (matchCountRequiresBonusCheck(matchCount)) {
            return lotto.getNumbers().contains(bonusNumber);
        }
        return false;
    }

    private boolean matchCountRequiresBonusCheck(int matchCount) {
        return matchCount == MATCH_COUNT_FOR_BONUS_CHECK;
    }

    public Map<WinningCriteria, Integer> getNumberMatchResult() {
        return numberMatchResult;
    }
}
