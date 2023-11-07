package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Statistician {
    public WinningStatistics makeLottoStatistics(LottoAmount lottoAmount, List<Lotto> lottoList, WinningLotto winningLotto) {
        Map<Ranking, Integer> rankingNumber = new EnumMap<>(Ranking.class);

        lottoList.stream()
                .map(lotto -> matchRanking(lotto, winningLotto))
                .filter(Optional::isPresent)
                .forEach(rankingOptional -> rankingNumber.merge(rankingOptional.get(), 1, Integer::sum));

        return new WinningStatistics(lottoAmount, rankingNumber);
    }

    private Optional<Ranking> matchRanking(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = matchCount(lotto, winningLotto.getNumbers());
        boolean matchBonus = matchBonusNumber(lotto, winningLotto.getBonusNumber());

        if (matchCount >=3) {
            return Optional.of(Ranking.of(matchCount, matchBonus));
        }

        return Optional.empty();
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
