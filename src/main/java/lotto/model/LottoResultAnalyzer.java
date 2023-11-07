package lotto.model;

import lotto.model.dto.LottoResultDTO;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResultAnalyzer {
    private EnumMap<PrizeCategory, Integer> matchResults = new EnumMap<>(PrizeCategory.class);

    public int calculateMatchCount(LottoPaper lottoPaper, List<Integer> winningNumbers) {
        return (int) lottoPaper.getLottoNumbers().stream()
                .filter(number -> winningNumbers.contains(number))
                .count();
    }

    public void writeResultToLottoPaper(LottoPaper lottoPaper, List<Integer> winningNumbers) {
            int calculatedMatchCount = calculateMatchCount(lottoPaper, winningNumbers);
            lottoPaper.setMatchingCount(calculatedMatchCount);
    }

    public void writeResultToLottoPapers(List<LottoPaper> lottoPapers, List<Integer> winningNumbers) {
        lottoPapers.stream()
                .forEach(paper -> writeResultToLottoPaper(paper, winningNumbers));
    }

    public void matchByLottoPaper(LottoPaper lottoPaper, int bonusNumber) {
        for (PrizeCategory category : PrizeCategory.values()) {
            if (lottoPaper.getMatchingCount() == category.MATCH_COUNT) {
                updateMatchResults(category, lottoPaper, bonusNumber);
                return;
            }
        }
    }

    private void updateMatchResults(PrizeCategory category, LottoPaper lottoPaper, int bonusNumber) {
        if (category == PrizeCategory.FIVE_MATCH_NO_BONUS && lottoPaper.hasBonusNumber(bonusNumber)) {
            category = PrizeCategory.FIVE_MATCH_WITH_BONUS;
        }
        matchResults.put(category, matchResults.getOrDefault(category, 0) + 1);
    }

    public void matchByLottoPapers(List<LottoPaper> lottoPapers, int bonusNumber) {
        lottoPapers.stream()
                .forEach(paper -> matchByLottoPaper(paper, bonusNumber));
    }

    public long calculateTotalWinningPrize(EnumMap<PrizeCategory, Integer> matchResults) {
        return matchResults.entrySet().stream()
                .mapToLong(entry -> entry.getKey().calculatePrize(entry.getValue()))
                .sum();
    }

    public EnumMap<PrizeCategory, Integer> getMatchResults() {
        return matchResults;
    }
}
