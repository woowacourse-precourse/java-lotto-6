package lotto.dto;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class MatchResultResponse {

    private final Map<Rank, Integer> rankCount;

    public MatchResultResponse(Map<Rank, Integer> rankCount) {
        this.rankCount = rankCount;
    }

    @Override
    public String toString() {
        return "당첨 통계\n---\n"
                + "3개 일치 (5,000원) - " + rankCount.get(Rank.FIFTH) + "개\n"
                + "4개 일치 (50,000원) - " + rankCount.get(Rank.FOURTH) + "개\n"
                + "5개 일치 (1,500,000원) - " + rankCount.get(Rank.FOURTH) + "개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankCount.get(Rank.SECOND) + "개\n"
                + "6개 일치 (2,000,000,000원) - " + rankCount.get(Rank.FIRST) + "개";
    }
}
