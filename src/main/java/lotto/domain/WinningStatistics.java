package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {

    private static final int ZERO = 0;

    private Map<Ranking, Integer> statistics = new EnumMap<>(Ranking.class);

    public WinningStatistics(WinningLotto winningLotto, Lottos lottos) {
        Arrays.stream(Ranking.values())
            .forEach(ranking -> statistics.put(ranking, ZERO));

        produceStatistics(winningLotto, lottos);
    }

    private void produceStatistics(WinningLotto winningLotto, Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            Ranking ranking = winningLotto.calculateRanking(lotto);
            Integer previousSameNumberCount = statistics.get(ranking);
            statistics.put(ranking, ++previousSameNumberCount);
        }
    }

    public Map<Ranking, Integer> getStatistics() {
        return Collections.unmodifiableMap(statistics);
    }

    public Money calculateTotalWinningPrize() {
        List<Ranking> rankings;
        rankings = new ArrayList<>(List.of(Ranking.values()));
        long totalWinningPrize = ZERO;
        for (Ranking ranking : rankings) {
            totalWinningPrize += statistics.get(ranking) * ranking.getPrizeMoney();
        }
        return new Money(totalWinningPrize);
    }
}
