package lotto.domain;

import lotto.Statistic;

import java.util.*;

public class WinningLotto {
    private List<Integer> numbers;   //입력 당첨 번호
    private int bonus;
    private Map<Statistic, Integer> match;

    public WinningLotto(List<Integer> numbers, int bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
        this.match = reset();
    }

    public Map reset() {
        Map<Statistic, Integer> reset = new HashMap<>();
        reset.put(Statistic.MATCH_THREE, 0);
        reset.put(Statistic.MATCH_FOUR, 0);
        reset.put(Statistic.MATCH_FIVE, 0);
        reset.put(Statistic.MATCH_FIVE_WITH_BONUS, 0);
        reset.put(Statistic.MATCH_SIX, 0);
        return reset;
    }

    public void accordCheck(Lottos lottos, Player player) {
        for (int i = 0; i < lottos.getLotto().size(); i++) {

            int count = countCheck(lottos, i);

            if (count < 3) continue;
            Statistic statistic = Statistic.getStatistic(count);

            if (Statistic.MATCH_THREE == statistic)
                match.put(Statistic.MATCH_THREE, match.getOrDefault(Statistic.MATCH_THREE, 0) + 1);
            if (Statistic.MATCH_FOUR == statistic)
                match.put(Statistic.MATCH_FOUR, match.getOrDefault(Statistic.MATCH_FOUR, 0) + 1);
            if (Statistic.MATCH_FIVE == statistic && !(lottos.getLotto().get(i).getNumbers().contains(bonus)))
                match.put(Statistic.MATCH_FIVE, match.getOrDefault(Statistic.MATCH_FIVE, 0) + 1);
            if (Statistic.MATCH_FIVE == statistic && (lottos.getLotto().get(i).getNumbers().contains(bonus))) {
                match.put(Statistic.MATCH_FIVE_WITH_BONUS, match.getOrDefault(Statistic.MATCH_FIVE_WITH_BONUS, 0) + 1);
                statistic = Statistic.MATCH_FIVE_WITH_BONUS;
            }
            if (Statistic.MATCH_SIX == statistic)
                match.put(Statistic.MATCH_SIX, match.getOrDefault(Statistic.MATCH_SIX, 0) + 1);

            player.sumPrize(statistic.getPrize());
        }
    }

    public int countCheck(Lottos lottos, int index) {
        int count = 0;
        for (Integer number : numbers) {
            if ((lottos.getLotto().get(index).getNumbers()).contains(number))
                count++;
        }
        return count;
    }

    public Map<Statistic, Integer> getMatch() {
        return match;
    }
}
