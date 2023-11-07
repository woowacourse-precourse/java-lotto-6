package lotto.domain;

import java.util.HashMap;
import java.util.List;
import lotto.config.RankType;

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

    public float getRateOfReturn(int purchaseAmount) {
        return (makeTotalReturn() / purchaseAmount) * 100;
    }

    private float makeTotalReturn() {
        float totalReturn = 0;
        for (int i = 5; i > 0; i--) {
            totalReturn += RankType.findByRank(i).getPrice() * result.get(i);
        }
        return totalReturn;
    }
}
