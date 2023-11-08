package model;

import java.util.Map;
import static model.LottoRepository.*;

public class LottoProfitCalculator {
    public double calculateLottoProfit(Map<Rank, Integer> winningDetails, double lottoPurchaseAmount) {
        double winningAmount = calculateWinningAmount(winningDetails);
        return winningAmount / lottoPurchaseAmount * 100;
    }

    private int calculateWinningAmount(Map<Rank, Integer> winningDetails) {
        int winningAmount = 0;
        int fifthCount = winningDetails.get(Rank.FIFTH);
        int fourthCount = winningDetails.get(Rank.FOURTH);
        int thirdCount = winningDetails.get(Rank.THIRD);
        int secondCount = winningDetails.get(Rank.SECOND);
        int firstCount = winningDetails.get(Rank.FIRST);

        winningAmount += fifthCount * 5000;
        winningAmount += fourthCount * 50000;
        winningAmount += thirdCount * 1500000;
        winningAmount += secondCount * 30000000;
        winningAmount += firstCount * 2000000000;

        return winningAmount;
    }
}