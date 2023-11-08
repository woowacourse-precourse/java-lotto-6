package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class Prize {
    private final Map<Ranking, Integer> prizeResult;

    public Prize() {
        prizeResult = new EnumMap<Ranking, Integer>(Ranking.class);
        Arrays.stream(Ranking.values())
                .forEach(ranking -> prizeResult.put(ranking, 0));
    }

    public void calculatePrize(LottoWin lottoWin, Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            Ranking ranking = Ranking.getRanking(lotto.getMatchLottoNumber(lottoWin),
                    lotto.isContain(lottoWin.getBonnusNumber()));
            updatePrizeCount(ranking);
        }
    }

    private void updatePrizeCount(Ranking ranking) {
        prizeResult.put(ranking, prizeResult.get(ranking) + 1);
    }

    public Integer getPrizeCount(Ranking ranking) {
        return prizeResult.get(ranking);
    }
}
