package lotto;

import static lotto.Constants.UNIT;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private Map<ResultCase, Integer> result;

    public Result() {
        result = new HashMap<>();
    }

    public void save(ResultCase resultCase, int matchLotto) {
        if (result.containsKey(resultCase)) {
            result.put(resultCase, result.get(resultCase) + matchLotto);
            return;
        }
        result.put(resultCase, matchLotto);
    }

    public void print() {
        for (ResultCase resultCase : ResultCase.values()) {
            System.out.println(resultCase.getComment() + result.get(resultCase) + UNIT);
        }
    }

    public double getCalculateRateOfReturn(int buyingPrice) {
        double rateOfReturn = ((double) getWinningPrice() / buyingPrice) * 100;
        double refinedRateOfReturn = Math.round(rateOfReturn * Math.pow(10, 2)) / Math.pow(10, 2);
        return refinedRateOfReturn;
    }

    private int getWinningPrice() {
        int winningPrice = 0;
        for (Map.Entry<ResultCase, Integer> entry : result.entrySet()) {
            ResultCase resultCase = entry.getKey();
            Integer matchLotto = entry.getValue();
            winningPrice += resultCase.getPrice() * matchLotto;
        }
        return winningPrice;
    }
}
