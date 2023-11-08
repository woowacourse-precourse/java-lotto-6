package lotto.domain;

import java.util.List;

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

    public String buildRankingMessage() {
        return "";
    }

    public String buildRateOfReturnMessage() {
        return "";
    }

    public List<Integer> getRankings() {
        return rankings.getRankings();
    }

    public double getRateOfReturn() {
        return rateOfReturn.getPercent();
    }
}
