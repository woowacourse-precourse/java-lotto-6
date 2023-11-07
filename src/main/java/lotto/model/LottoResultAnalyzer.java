package lotto.model;

import java.util.EnumMap;
import java.util.List;

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
}
