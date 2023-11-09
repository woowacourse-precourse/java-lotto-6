package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoRanking;

public class LottoPocket {
    private List<Lotto> lottos;
    private List<LottoRanking> rankings;

    public LottoPocket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setRankings(List<LottoRanking> rankings) {
        this.rankings = rankings;
    }

    public long getRankingCount(LottoRanking ranking) {
        return rankings.stream().filter(ranking::equals).count();
    }

    public double getRateOfReturn(int money) {
        return rankings.stream().map(ranking -> ranking.getPrice()).reduce(0, Integer::sum) / money * 100;
    }
}
