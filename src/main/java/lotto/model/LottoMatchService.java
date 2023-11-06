package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class LottoMatchService {
    public List<Ranking> checkWinningNumbers(List<Lotto> lottos, List<Integer> winningNumbers) {
        return lottos.stream()
                .map(lotto -> findMatches(lotto, winningNumbers))
                .collect(Collectors.toList());
    }

    private Ranking findMatches(Lotto lotto, List<Integer> winningNumbers) {
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
        return Ranking.findByMatchCount(matchCount);
    }
}
