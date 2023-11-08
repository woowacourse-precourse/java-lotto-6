package lotto.model;

import lotto.constant.Constant;
import lotto.constant.LottoRateConstant;
import lotto.constant.Ranking;

import java.util.EnumMap;
import java.util.Map;

public class RankStatus {
    private final Map<Ranking, Integer> rankings;

    private RankStatus() {
        rankings = new EnumMap<Ranking, Integer>(Ranking.class);
        for (Ranking rank : Ranking.values()) {
            rankings.put(rank, 0);
        }
    }

    public static RankStatus getInstance() {
        return new RankStatus();
    }

    public void updateRankStatus(Ranking ranking) {
        rankings.put(ranking, rankings.get(ranking) + 1);
    }

    public int getRankNum(Ranking ranking) {
        return rankings.get(ranking);
    }

    public String makeLottoRate() {
        StringBuilder lottoRate = new StringBuilder();
        lottoRate
                .append(LottoRateConstant.FIFTH_LOTTO_MESSAGE.getMessage(getRankNum(Ranking.FIFTH)))
                .append(Constant.NEW_LINE.getMessage())
                .append(LottoRateConstant.FOURTH_LOTTO_MESSAGE.getMessage(getRankNum(Ranking.FOURTH)))
                .append(Constant.NEW_LINE.getMessage())
                .append(LottoRateConstant.THIRD_LOTTO_MESSAGE.getMessage(getRankNum(Ranking.THIRD)))
                .append(Constant.NEW_LINE.getMessage())
                .append(LottoRateConstant.SECOND_LOTTO_MESSAGE.getMessage(getRankNum(Ranking.SECOND)))
                .append(Constant.NEW_LINE.getMessage())
                .append(LottoRateConstant.FIRST_LOTTO_MESSAGE.getMessage(getRankNum(Ranking.FIRST)));
        return lottoRate.toString();
    }
}
