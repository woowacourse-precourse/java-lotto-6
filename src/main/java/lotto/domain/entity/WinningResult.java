package lotto.domain.entity;

import java.util.Map;

public class WinningResult {
    ThousandUnitMoney totalPrice;
    Percent rateOfReturn;
    Rankings rankings; //3등몇개 2등몇개


    private WinningResult(ThousandUnitMoney totalPrice, Percent rateOfReturn, Rankings rankings) {
        this.totalPrice = totalPrice;
        this.rateOfReturn = rateOfReturn;
        this.rankings = rankings;
    }

    public static WinningResult create(ThousandUnitMoney totalPrice, Percent rateOfReturn, Rankings rankings) {
        return new WinningResult(totalPrice, rateOfReturn, rankings);
    }

    public Map<Ranking, Integer> getRankings() {
        return rankings.getRankings();
    }

    public double getRateOfReturn() {
        return rateOfReturn.getPercent();
    }
}
