package lotto.model;

import static lotto.constants.LottoConstants.PRICE_OF_LOTTO;

import java.util.List;
import lotto.constants.LottoConstants;
import lotto.converter.MessageConverter;

public class Result {
    private final List<Ranking> rankings;
    private final double totalProfit;

    public Result(List<Ranking> rankings) {
        this.rankings = rankings;
        this.totalProfit = calculateTotalProfit(rankings.size()* PRICE_OF_LOTTO);
    }

    private double calculateTotalProfit(int payment) {
        double profit = 0;
        for (Ranking ranking : rankings) {
            profit += ranking.getProfit();
        }
        return (profit / payment) * 100;
    }

    public String writeResultsOfRanks() {
        return MessageConverter.writeResultsOfRanks(rankings);
    }

    public double getTotalProfit() {
        return totalProfit;
    }
}
