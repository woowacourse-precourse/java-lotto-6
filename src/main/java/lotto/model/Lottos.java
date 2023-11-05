package lotto.model;

import lotto.config.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public static Lottos from(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public Map<Rank, Long> calculateResults(List<Integer> winningNumbers, int bonusNumber) {
        return lottos.stream()
                .map(lotto -> determineRank(lotto, winningNumbers, bonusNumber))
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }

    private Rank determineRank(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        long matchCount = lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
        boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

        return Rank.valueOf(matchCount, bonusMatch);
    }
}
