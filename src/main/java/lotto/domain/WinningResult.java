package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class WinningResult {
    private static final int PERCENTAGE = 100;
    private static final int INIT_NUMBER = 0;

    private final Map<Rank, Integer> winningResult;

    public WinningResult() {
        this.winningResult = new EnumMap<>(Rank.class);

        Arrays.stream(Rank.values())
                .forEach(rank -> winningResult.put(rank, 0));
    }

    public void calculateWinning(Lottos lottos, WinningNumber winningNumber) {
        for (Lotto lotto : lottos.getLottos()) {
            Rank from = Rank.from(lotto.calculateMatchCount(winningNumber.getWinningNumber()),
                    lotto.isContain(winningNumber.getBonusNumber()));

            winningResult.put(from, winningResult.get(from) + 1);
        }
    }

    public int getWinningCount(Rank rank) {
        return winningResult.get(rank);
    }

    public float calculateRate(Lottos lottos) {
        int totalPrize = INIT_NUMBER;

        for (Rank rank : winningResult.keySet()) {
            if (rank == Rank.BLANK) {
                continue;
            }

            totalPrize += winningResult.get(rank) * rank.getPrize();
        }

        return ((float) totalPrize / lottos.getMoney()) * PERCENTAGE;
    }
}
