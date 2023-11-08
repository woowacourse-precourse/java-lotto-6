package lotto.domain;

import lotto.utils.RandomNumbersGenerator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int count) {
        this.lottos = createLottos(count);
    }

    private List<Lotto> createLottos(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(RandomNumbersGenerator.generateRandomNumber()))
                .collect(Collectors.toList());
    }

    public Map<Ranking, Integer> countRankings(Lotto winningLotto, int bonus) {
        Map<Ranking, Integer> result = initRanking();

        lottos.forEach(lotto -> {
            int count = lotto.countWinningNumber(winningLotto);
            boolean hasBonusNumber = needToCheckBonusNumber(lotto, count, bonus);
            Optional<Ranking> ranking = Ranking.rank(count, hasBonusNumber);
            ranking.ifPresent(r -> result.put(r, result.get(r) + 1));
        });
        return result;
    }

    private Map<Ranking, Integer> initRanking() {
        Map<Ranking, Integer> result = new EnumMap<>(Ranking.class);
        Arrays.stream(Ranking.values())
                .forEach(ranking -> result.put(ranking, 0));
        return result;
    }

    private boolean needToCheckBonusNumber(Lotto lotto, int count, int bonus) {
        if (count == 5) {
            return lotto.hasBonusNumber(bonus);
        }
        return false;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
