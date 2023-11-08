package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculate {
    private List<Lotto> lottos;
    private List<Integer> answer;
    private int bonus;
    private int[] rank = new int[7];

    public Calculate(List<Lotto> lottos, List<Integer> answer, int bonus) {
        this.lottos = lottos;
        this.answer = answer;
        this.bonus = bonus;
    }

    private int count(List<Integer> lotto) {
        int count = 0;
        for (Integer integer : answer) {
            if (lotto.contains(integer)) {
                count += 1;
            }
        }
        return count;
    }

    public void countAll() {
        for (int i = 0; i < lottos.size(); i++) {
            int cnt = count(lottos.get(i).getLotto());
            if (cnt == 6) rank[1] += 1;
            else if (cnt == 5) {
                rank[containBonus(lottos.get(i).getLotto())] += 1;
            }
            else if (cnt == 4) rank[4] += 1;
            else if (cnt == 3) rank[5] += 1;
            else if (cnt < 3) rank[0] += 1;
        }
    }

    public int containBonus(List<Integer> lotto) {
        if (lotto.contains(bonus)) {
            return 2;
        }
        return 3;
    }

    public int[] getRank() {
        return rank;
    }
}
