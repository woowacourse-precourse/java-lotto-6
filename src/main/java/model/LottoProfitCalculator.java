package model;

import java.util.Map;
import static model.LottoRepository.*;

public class LottoProfitCalculator {
    public double calculateLottoProfit(Map<Integer, Integer> winningDetails, double lottoPurchaseAmount) {
        double winningAmount = calculateWinningAmount(winningDetails);
        return winningAmount / lottoPurchaseAmount * 100;
    }

    private int calculateWinningAmount(Map<Integer, Integer> winningDetails) {
        int winningAmount = 0;
        int fifthCount = winningDetails.get(RANK_FIFTH);
        int fourthCount = winningDetails.get(RANK_FOURTH);
        int thirdCount = winningDetails.get(RANK_THIRD);
        int secondCount = winningDetails.get(RANK_SECOND);
        int firstCount = winningDetails.get(RANK_FIRST);

        winningAmount += fifthCount * 5000;
        winningAmount += fourthCount * 50000;
        winningAmount += thirdCount * 1500000;
        winningAmount += secondCount * 30000000;
        winningAmount += firstCount * 2000000000;

        return winningAmount;
    }
}