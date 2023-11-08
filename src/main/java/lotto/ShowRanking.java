package lotto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class ShowRanking {
    private final Map<Ranking, Integer> rankingResult;

    public ShowRanking() {
        rankingResult = new EnumMap<Ranking, Integer>(Ranking.class);
        Arrays.stream(Ranking.values())
                .forEach(rank -> rankingResult.put(rank, 0));
    }

    public void calcRankingResult(WinNumber winNumber, LottoList lottoList) {
        for (Lotto lotto : lottoList.getLottoList()) {
            Ranking ranking = Ranking.getRanking(lotto.getMatchNumber(winNumber),
                    lotto.isContain(winNumber.getBonusNumber()));
            updateRankCount(ranking);
        }
    }

    private void updateRankCount(Ranking ranking) {
        rankingResult.put(ranking, rankingResult.get(ranking) + 1);
    }

    public Integer getRankCount(Ranking ranking) {
        return rankingResult.get(ranking);
    }
}
