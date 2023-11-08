package lotto.util;

import java.util.HashMap;
import lotto.config.LottoResultInform;

public class StatisticsCalculator {
    public String getRate(HashMap<Integer, Integer> winResult, int lottoCount) {
        return String.format("%.1f", calculate(winResult, lottoCount));
    }

    public float calculate(HashMap<Integer, Integer> winResult, int lottoCount) {
        return addTotalPrize(winResult) / lottoCount / 10.0f;
    }

    private float addTotalPrize(HashMap<Integer, Integer> winResult) {
        float prize = 0.0f;
        for (LottoResultInform result : LottoResultInform.values()) {
            prize = prize + (float) result.getMoney() * winResult.get(result.getCount());
        }
        return prize;
    }


}
