package lotto.model;

import static lotto.configuration.LottoConfiguration.LOTTO_PRICE;

import java.util.EnumMap;
import java.util.List;

public class Customer {
    private List<Lotto> lottos;
    private final EnumMap<Ranking, Integer> rankingCounts;

    public Customer() {
        rankingCounts = new EnumMap<>(Ranking.class);
        for (Ranking ranking : Ranking.values()) {
            rankingCounts.put(ranking, 0);
        }
    }

    public void buyLotto(Money money) {
        this.lottos = LottoGenerator.issueLottoTickets(money);
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public String getLottosString() {
        StringBuilder sb = new StringBuilder();
        lottos.forEach((lotto) -> sb.append(lotto.toString()).append("\n"));
        return sb.toString();
    }

    public void matchLotto(WinLotto winLotto) {
        for (Lotto lotto : lottos) {
            Ranking ranking = winLotto.findOutLottoRanking(lotto);
            updateRankingCount(ranking);
        }
    }

    private void updateRankingCount(Ranking ranking) {
        rankingCounts.put(ranking, rankingCounts.get(ranking) + 1);
    }

    public String getMatchResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Ranking ranking : Ranking.values()) {
            if (ranking == Ranking.NONE) {
                continue;
            }
            stringBuilder.append(ranking.getWinningString()).append(rankingCounts.get(ranking)).append("개\n");
        }
        return stringBuilder.toString();
    }

    public double calculateReturnRate() {
        double seedMoney = (double) (lottos.size() * LOTTO_PRICE.get());
        double returnMoney = 0L;
        for (EnumMap.Entry<Ranking, Integer> entry : rankingCounts.entrySet()) {
            Ranking ranking = entry.getKey();
            Integer count = entry.getValue();
            returnMoney += ranking.getWinningsByInt() * count;
        }
        return (1L - ((seedMoney - returnMoney) / seedMoney)) * 100;
    }

}
