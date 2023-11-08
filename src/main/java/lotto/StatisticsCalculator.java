package lotto;

import java.util.HashMap;

public class StatisticsCalculator {
    public void calculate(HashMap<Integer, Integer> winResult, int lottoCount) {

    }

    private float addTotalPrize(HashMap<Integer, Integer> winResult) {
        float prize = 0.0f;
        for (LottoResult result : LottoResult.values()) {
            prize = prize + (float) result.getMoney() * winResult.get(result.getCount());
        }
        return prize;
    }
}
