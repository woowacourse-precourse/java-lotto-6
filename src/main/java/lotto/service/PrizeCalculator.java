package lotto.service;

import lotto.model.AppConstants;

import java.util.Map;

public class PrizeCalculator {
    public static int calculate(Map<String, Integer> lottoMatchingResult) {
        int totalPrize = 0;
        for(Map.Entry<String, Integer> entry : lottoMatchingResult.entrySet()) {
            String rankKey = entry.getKey();
            Integer value = entry.getValue();
            totalPrize += calculatePrize(rankKey, value);
        }

        return totalPrize;
    }

    private static int calculatePrize(String key, int value) {
        int prize = 0;
        for(AppConstants.lottoMatchingConstants constants : AppConstants.lottoMatchingConstants.values()) {
            if(constants.grade.equals(key)) {
                prize = constants.prizeAmount * value;
            }
        }
        return prize;
    }

    public static float calculateProfitRate(int totalPrize, int inputPrice) {
        float prifit = ((float) totalPrize / inputPrice) * 100;
        return prifit;
    }


}
