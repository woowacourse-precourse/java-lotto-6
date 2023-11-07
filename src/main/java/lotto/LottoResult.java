package lotto;

import java.text.NumberFormat;
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
        NumberFormat nf = NumberFormat.getInstance();
        for (LottoPrize prize : LottoPrize.values()) {
            int count = results.get(prize);
            String prizeAmountFormatted = nf.format(prize.getPrizeAmount()); // 숫자를 형식화
            if(prize == LottoPrize.MATCH_5_BONUS){
                String resultString = prize.getMatchingNumbers() + "개 일치, 보너스 볼 일치 (" + prizeAmountFormatted + "원) - " + count + "개";
                resultStrings.add(resultString);
                continue;
            }
            String resultString = prize.getMatchingNumbers() + "개 일치 (" + prizeAmountFormatted + "원) - " + count + "개";
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