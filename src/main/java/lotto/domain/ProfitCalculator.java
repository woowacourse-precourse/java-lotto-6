package lotto.domain;


import static lotto.constant.NumberConstants.*;

public class ProfitCalculator {
    public static int calculateProfit(LottoResult lottoResult) {
        return lottoResult.getLOTTO_RESULT().entrySet().stream()
                .filter(rank -> rank.getKey() != LottoRank.NO_RANK)
                .map(rank -> rank.getKey().getPrizeMoney() * rank.getValue())
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static double calculateProfitMargin(int profit, int amount) {
        double result = (double) profit / amount;
        return result * HUNDRED;
    }

    public static double totalProfitMargin(LottoResult lottoResult, PurchaseLotto purchaseLottoAmount) {
        int profit = calculateProfit(lottoResult);
        return calculateProfitMargin(profit, purchaseLottoAmount.getPurchaseAmount());
    }

}
