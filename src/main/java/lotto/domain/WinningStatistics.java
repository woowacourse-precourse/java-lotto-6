package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class WinningStatistics {

    private Map<Ranking, Integer> statistics = new EnumMap<>(Ranking.class);

    public WinningStatistics(WinningLotto winningLotto, Lottos lottos) {
        Arrays.stream(Ranking.values())
            .forEach(ranking -> statistics.put(ranking, 0));

        produceStatistics(winningLotto, lottos);
    }

    private void produceStatistics(WinningLotto winningLotto, Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            Ranking ranking = winningLotto.calculateRanking(lotto);
            Integer previousSameNumberCount = statistics.get(ranking);
            statistics.put(ranking, ++previousSameNumberCount);
        }
    }
}
