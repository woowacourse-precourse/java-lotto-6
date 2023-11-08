package lotto.domain;

import java.util.Arrays;

public class LottoProfit {

    public double calculateProfitRate(LottoResult lottoResult, int purchaseAmount) {
        int profit = calculateProfit(lottoResult);
        return (double) profit / (double) purchaseAmount * 100;
    }

    public int calculateProfit(LottoResult lottoResult) {
        return Arrays.stream(LottoRank.values())
                .mapToInt(lottoRank -> lottoRank.getPrize() * lottoResult.getCount(lottoRank))
                .sum();
    }

}