package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private final List<Lotto> lottos;
    private final WinningLotto winningLotto;
    public Game(final List<Lotto> lottos, final WinningLotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
    }

    public Map<Rank, Integer> run() {
        Map<Rank, Integer> result = new HashMap<>(
                Map.of(Rank.FIRST, 0, Rank.SECOND, 0, Rank.THIRD, 0,
                        Rank.FOURTH, 0, Rank.FIFTH, 0, Rank.MISS, 0));

        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.confirmWin(lotto);
            result.compute(rank, (key, value) -> value + 1);
        }
        return result;
    }

    public double getEarningRate(final Map<Rank, Integer> result, final int purchaseAmount) {
        long totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : result.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            totalPrize += (long) rank.getPrize() * count;
        }
        return (double) totalPrize / purchaseAmount * 100;
    }
}

