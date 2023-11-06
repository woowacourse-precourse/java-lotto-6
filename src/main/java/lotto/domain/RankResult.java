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

    public void calcPrizeResult(WonLotto wonLotto, List<Lotto> numbers) {
        for (Lotto lotto : numbers) {
            Rank prize = Rank.getPrize(lotto.numbersMatchWonLottoNumber(wonLotto),
                    lotto.isContain(wonLotto.getBonusNumber()));
            updatePrizeCount(prize);
        }
    }

    private void updatePrizeCount(Rank prize) {
        rankResult.put(prize, rankResult.get(prize) + 1);
    }

    public Integer getPrizeCount(Rank prize) {
        return rankResult.get(prize);
    }
}
