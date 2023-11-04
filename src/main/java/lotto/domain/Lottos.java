package lotto.domain;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

import java.util.List;
import java.util.Map;

public class Lottos {

    private final List<Lotto> lottos;
    private final int number;
    private Map<Ranking, Integer> winningStatics;
    private int totalPrize;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
        this.number = lottos.size();
    }



    private void calculateWinningStatistics(List<Integer> winningNumbers, int bonusNumber) {
        winningStatics = lottos.stream()
                .collect(groupingBy(
                        lotto -> lotto.getRanking(winningNumbers, bonusNumber),
                        summingInt(lotto -> 1)
                ));
    }
}
