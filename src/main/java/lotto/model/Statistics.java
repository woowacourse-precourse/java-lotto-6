package lotto.model;

import static lotto.constant.Constant.ZERO;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.constant.Rank;

public class Statistics {
    private final Map<Rank, Integer> result;

    private Statistics() {
        result = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            result.put(rank, ZERO);
        }
    }

    public static Statistics createStatistics() {
        return new Statistics();
    }

    public Map<Rank, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }

    public void calculateMatching(LottoNumbers lottoNumbers, WinnerNumber winnerNumber, BonusNumber bonusNumber) {
        List<Lotto> lottos = lottoNumbers.getNumbers();

        for (Lotto lotto : lottos) {
            Rank rank = findRank(lotto, winnerNumber, bonusNumber);
            int lottoCount = result.get(rank) + 1;

            result.put(rank, lottoCount);
        }
    }

    private Rank findRank(Lotto lotto, WinnerNumber winnerNumber, BonusNumber bonusNumber) {
        long winnerMatch = countMatchingWinnerNumber(lotto, winnerNumber);
        boolean bonusMatch = matchingBonusNumber(lotto, bonusNumber);

        return Rank.findRank(winnerMatch, bonusMatch);
    }

    private boolean matchingBonusNumber(Lotto lotto, BonusNumber bonusNumber) {
        return lotto.getNumbers().stream()
                .anyMatch(number -> number.equals(bonusNumber.isSameBonusNumber(bonusNumber)));
    }

    private long countMatchingWinnerNumber(Lotto lotto, WinnerNumber winnerNumber) {
        return lotto.getNumbers().stream()
                .filter(winnerNumber.getWinnerNumbers()::contains)
                .count();
    }
}
