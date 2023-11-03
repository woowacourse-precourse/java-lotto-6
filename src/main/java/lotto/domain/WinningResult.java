package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class WinningResult {
    private final Map<Rank, Integer> winningResult;

    public WinningResult() {
        this.winningResult = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values())
                .forEach(prize -> winningResult.put(prize, 0));
    }

    public void calculateWinning(Lottos lottos, WinningNumber winningNumber) {
        for (Lotto lotto : lottos.getLottos()) {
            Rank from = Rank.from(lotto.calculateMatchCount(winningNumber.getWinningNumber())
                    , lotto.isContain(winningNumber.getBonusNumber()));
            winningResult.put(from, winningResult.get(from) + 1);
        }
    }

    public int getWinningCount(Rank rank) {
        return winningResult.get(rank);
    }
}
