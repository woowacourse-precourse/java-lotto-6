package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Ranking {

    private final Map<Rank, Integer> ranking;

    public Ranking() {
        ranking = new EnumMap<Rank, Integer>(Rank.class);
        for (Rank rank : Rank.values()) {
            ranking.put(rank, 0);
        }
    }

    public void rewardRanking(Winnings winnings, Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            int matchNums = getMatchNumbers(winnings.getWins(), lotto.getNumbers());
            boolean matchBonus = getMatchBonus(winnings.getBonus(), lotto.getNumbers());
            Rank rank = Rank.findRank(matchNums, matchBonus);
            updateCount(rank);
        }
    }

    public int getMatchNumbers(List<Integer> wins, List<Integer> numbers) {
        int match = 0;
        for (int num : numbers) {
            if (wins.contains(num)) {
                match++;
            }
        }
        return match;
    }

    public boolean getMatchBonus(int bonus, List<Integer> numbers) {
        if (numbers.contains(bonus)) {
            return true;
        }
        return false;
    }

    public void updateCount(Rank rank) {
        ranking.put(rank, ranking.get(rank) + 1);
    }

    public int getCount(Rank rank) {
        return ranking.get(rank);
    }

}
