package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;

public class CompareNumber {

    public static Map<Ranking, Integer> CompareNumbers(List<Lotto> lottos, Lotto winner_lotto, int bonus_number) {

        Map<Ranking, Integer> result = new HashMap<>();

        for(Ranking rank: Ranking.values()){
            result.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            Ranking rank = Ranking.Matching(lotto.CompWinner(winner_lotto), lotto.ContainNumber(bonus_number));
            result.put(rank, result.get(rank) + 1);
        }
        return result;
    }

}
