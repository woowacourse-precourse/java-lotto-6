package lotto.domain;
import lotto.model.MatchingCounts;
import lotto.model.Purchase;

public class Calculator {
    public Calculator() {
    }

    public String calculateProfitPercentage(MatchingCounts matchingCounts) {
        Prize[] prizes = {
                Prize.MATCH_3,
                Prize.MATCH_4,
                Prize.MATCH_5,
                Prize.MATCH_5_PLUS_BONUS,
                Prize.MATCH_6
        };

        int lineLottoTotal = 0;
        for (int i = 0; i < 5; i++) {
            lineLottoTotal += prizes[i].getPrizeAmount() * matchingCounts.getMatchingCount().get(i);
        }

        double profit  = (double) lineLottoTotal/Purchase.getPurchaseAmount()*100;
        return String.format("%.1f", profit);
    }
}
