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

    public void calcRankResult(UserLottoNum userLottoNum, Lottos lottos) {
        for(Lotto lotto : lottos.getLottos()) {
            Rank rank = Rank.getRank(lotto.getMatchLottoNum(userLottoNum),
                    lotto.isContain(userLottoNum.getBonusNum()));
            addRankCnt(rank);
        }
    }

    public void addRankCnt(Rank rank) {
        rankResult.put(rank, rankResult.get(rank) + 1);
    }

    public Integer getRankResultCnt(Rank rank) {
        return rankResult.get(rank);
    }
}
