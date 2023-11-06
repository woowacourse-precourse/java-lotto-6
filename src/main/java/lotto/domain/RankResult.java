package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class RankResult {
    private final Map<Rank, Integer> rankResult;

    public RankResult() {
        rankResult = new EnumMap<Rank, Integer>(Rank.class);
        Arrays.stream(Rank.values())
                .forEach(prize -> rankResult.put(prize, 0));
    }

    public void calculateRankResult(WonLotto wonLotto, List<Lotto> numbers) {
        for (Lotto lotto : numbers) {
            Rank rank = Rank.getRank(lotto.numbersMatchWonLottoNumber(wonLotto),
                    lotto.isContain(wonLotto.getBonusNumber()));
            updateRankCount(rank);
        }
    }

    private void updateRankCount(Rank rank) {
        rankResult.put(rank, rankResult.get(rank) + 1);
    }

    public Integer getRankCount(Rank rank) {
        return rankResult.get(rank);
    }
}
