package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class RankResult {
    private final Map<Rank, Integer> rankResult;

    public RankResult() {
        rankResult = new EnumMap<Rank, Integer>(Rank.class);
        Arrays.stream(Rank.values())
                .forEach(rank -> rankResult.put(rank, 0));
    }

    public void calculateRankResult(WinningNumber winningNumber, Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            Rank rank = Rank.calculate(lotto.getMatchLottoNumber(winningNumber),
                    lotto.isContain(winningNumber.getBonusNumber()));
            updateRankCount(rank);
        }
    }

    private void updateRankCount(Rank rank) {
        rankResult.put(rank, rankResult.get(rank) + 1);
    }
}
