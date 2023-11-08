package lotto.controller;

import lotto.model.Percent;
import lotto.model.PriceMoney;
import lotto.model.Ranking;
import lotto.model.LottoTicketMoney;

import java.util.Map;

public class ResultCalculationService {
    private PriceMoney priceMoney;
    private Percent incomingRate;

    public ResultCalculationService() {
        this.priceMoney = new PriceMoney(0);
    }

    public void calculatePrice(Map<Ranking, Integer> rankingCounts) {
        rankingCounts.forEach((ranking, count) -> {
            PriceMoney currentRankingPrice = ranking.calculateCurrentPrice(count);
            this.priceMoney.add(currentRankingPrice);
        });
    }

    public Percent calculateIncomeRate(LottoTicketMoney lottoTicketMoney) {
        this.incomingRate = new Percent(lottoTicketMoney, this.priceMoney);
        return this.incomingRate;
    }
}
