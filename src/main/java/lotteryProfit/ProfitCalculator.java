package lotteryProfit;

import static constant.ConstantNumber.NUMBER_INITIALIZATION;
import static game.LottoRank.FIFTH_RANK;
import static game.LottoRank.FIRST_RANK;
import static game.LottoRank.FOURTH_RANK;
import static game.LottoRank.SECOND_RANK;
import static game.LottoRank.THIRD_RANK;

import lottoResult.LottoResultDisplay;

public class ProfitCalculator {
    public double roundUpProfit(int totalReward, int purchaseAmount) {
        double profit = profitCalculator(totalReward, purchaseAmount);
        return Math.round(profit * 100.0) / 100.0;
    }

    public int getTotalReward(LottoResultDisplay lottoResult) {
        int sixSuccess = lottoResult.sixSuccess;
        int fiveSuccess = lottoResult.fiveSuccess;
        int fiveAndBonusSuccess = lottoResult.fiveAndBonusSuccess;
        int fourSuccess = lottoResult.fourSuccess;
        int threeSuccess = lottoResult.threeSuccess;

        int totalReward = NUMBER_INITIALIZATION;
        totalReward += FIFTH_RANK.getReward() * threeSuccess;
        totalReward += FOURTH_RANK.getReward() * fourSuccess;
        totalReward += THIRD_RANK.getReward() * fiveSuccess;
        totalReward += SECOND_RANK.getReward() * fiveAndBonusSuccess;
        totalReward += FIRST_RANK.getReward() * sixSuccess;
        return totalReward;
    }

    private double profitCalculator(int totalReward, int purchaseAmount) {
        return (double) totalReward / purchaseAmount * 100;
    }
}