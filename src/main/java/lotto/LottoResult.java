package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class LottoResult {
    private final Map<LottoPrize, Integer> results = new HashMap<>();

    public LottoResult() {
        for (LottoPrize prize : LottoPrize.values()) {
            results.put(prize, 0);
        }
    }

    public void increaseCount(LottoPrize prize) {
        results.put(prize, results.get(prize) + 1);
    }

    public List<String> getResultStrings() {
        List<String> resultStrings = new ArrayList<>();
        for (LottoPrize prize : LottoPrize.values()) {
            int count = results.get(prize);
            String resultString = prize.getMatchingNumbers() + "개 일치 (" + prize.getPrizeAmount() + "원) - " + count + "개";
            resultStrings.add(resultString);
        }
        return resultStrings;
    }

    public long getTotalPrizeAmount() {
        long totalAmount = 0;
        for (LottoPrize prize : LottoPrize.values()) {
            totalAmount += prize.getPrizeAmount() * results.get(prize);
        }
        return totalAmount;
    }
}