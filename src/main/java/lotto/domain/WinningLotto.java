package lotto.domain;

import lotto.Statistic;

import java.util.*;

public class WinningLotto {
    private final List<Integer> numbers;
    private final Map<Statistic, Integer> match;
    private final int bonus;
    private final int ADD_COUNT = 1;

    public WinningLotto(List<Integer> numbers, int bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
        this.match = reset();
    }

    public Map reset() {
        Map<Statistic, Integer> reset = new HashMap<>();
        for (Statistic stat : Statistic.values()) {
            reset.put(stat, 0);
        }
        return reset;
    }

    public void calculatePrize(Lottos lottos, Player player) {
        for (int i = 0; i < lottos.getLotto().size(); i++) {
            int count = containCheck(lottos, i);
            if (count < Statistic.MATCH_THREE.getMatchCount()) continue;
            Statistic statistic = countStatistic(lottos, count, i);
            player.sumPrize(statistic.getPrize());
        }
    }

    public int containCheck(Lottos lottos, int index) {
        int count = 0;
        for (Integer number : numbers) {
            if ((lottos.getLotto().get(index).getNumbers()).contains(number))
                count++;
        }
        return count;
    }

    public Statistic countStatistic(Lottos lottos, int count ,int index){
        Statistic statistic = Statistic.getStatistic(count);
        if (Statistic.MATCH_THREE == statistic) match.put(Statistic.MATCH_THREE, match.getOrDefault(Statistic.MATCH_THREE, 0) + ADD_COUNT);
        if (Statistic.MATCH_FOUR == statistic) match.put(Statistic.MATCH_FOUR, match.getOrDefault(Statistic.MATCH_FOUR, 0) + ADD_COUNT);
        if (Statistic.MATCH_FIVE == statistic && !(lottos.getLotto().get(index).getNumbers().contains(bonus))) match.put(Statistic.MATCH_FIVE, match.getOrDefault(Statistic.MATCH_FIVE, 0) + ADD_COUNT);
        if (Statistic.MATCH_FIVE == statistic && (lottos.getLotto().get(index).getNumbers().contains(bonus))) {
            match.put(Statistic.MATCH_FIVE_WITH_BONUS, match.getOrDefault(Statistic.MATCH_FIVE_WITH_BONUS, 0) + ADD_COUNT);
            statistic = Statistic.MATCH_FIVE_WITH_BONUS;
        }
        if (Statistic.MATCH_SIX == statistic) match.put(Statistic.MATCH_SIX, match.getOrDefault(Statistic.MATCH_SIX, 0) + ADD_COUNT);
        return statistic;
    }

    public Map<Statistic, Integer> getMatch() {
        return match;
    }
}
