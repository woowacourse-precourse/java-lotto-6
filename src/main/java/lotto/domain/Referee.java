package lotto.domain;

import java.util.HashMap;
import java.util.List;
import lotto.RankType;

public class Referee {
    private final HashMap<Integer, Integer> result;

    public Referee() {
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int i = 1; i < 6; i++) {
            result.put(i, 0);
        }
        this.result = result;
    }

    public void compare(List<Lotto> lottos, Lotto winningLotto, int bonus) {
        Judgment judgment = new Judgment();

        for (Lotto lotto : lottos) {
            int correctCount = judgment.correctCount(lotto.getNumbers(), winningLotto.getNumbers());
            boolean hasBonus = judgment.hasBonus(lotto.getNumbers(), bonus);

            if (correctCount > 2) {
                setResult(findRank(correctCount, hasBonus));
            }
        }
    }

    private void setResult(int rank) {
        result.put(rank, result.get(rank) + 1);
    }

    private int findRank(int correctCount, boolean hasBonus) {
        return RankType.findByCorrectCount(correctCount, hasBonus).getRank();
    }

    public HashMap<Integer, Integer> getResult() {
        return result;
    }
}
