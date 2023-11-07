package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Statistician {
    public WinningStatistics makeLottoStatistics(List<Lotto> lottoList, WinningLotto winningLotto) {
        Map<Ranking, Integer> rankingNumber = new EnumMap<>(Ranking.class);

        lottoList.stream()
                .map(lotto -> matchRanking(lotto, winningLotto))
                .forEach(key -> rankingNumber.merge(key, 1, Integer::sum));

        return new WinningStatistics(rankingNumber);
    }

    private Ranking matchRanking(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = matchCount(lotto, winningLotto.getNumbers());
        boolean matchBonus = matchBonusNumber(lotto, winningLotto.getBonusNumber());

        return Ranking.of(matchCount, matchBonus);
    }

    private int matchCount(Lotto lotto, List<Integer> numbers) {
        return (int) lotto.getNumbers().stream()
                .filter(numbers::contains)
                .count();
    }

    private boolean matchBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
