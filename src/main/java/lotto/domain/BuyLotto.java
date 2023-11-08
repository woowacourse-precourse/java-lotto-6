package lotto.domain;

import java.util.Map;

public class BuyLotto {

    public double calculateEarningsRate(Map<WinningPrize, Integer> winningStatus, int purchasePrice) {
        int sum = 0;
        double earningsRate = 0;

        for (int i = 0; i < winningStatus.size(); i++) {
            sum += WinningPrize.values()[i].getPrizeMoney() * winningStatus.get(WinningPrize.values()[i]);
        }
        earningsRate = (double) sum / purchasePrice;

        return earningsRate;
    }

    public int setPurchasePrice(int inputPrice) {
        return findAmount(inputPrice);
    }

    private int findAmount(int inputPrice) {
        return inputPrice / 1000;
    }
}
