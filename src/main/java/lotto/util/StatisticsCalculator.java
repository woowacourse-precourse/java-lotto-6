package lotto.util;

import java.util.HashMap;
import lotto.config.LottoResultInform;

public class StatisticsCalculator {
    private final static float Divider = 10.0f;

    public String getRate(HashMap<Integer, Integer> winResult, int lottoCount) {
        return String.format("%.1f", calculate(winResult, lottoCount));
    }

    public float calculate(HashMap<Integer, Integer> winResult, int lottoCount) {
        return addTotalPrize(winResult) / lottoCount / Divider;
    }

    private float addTotalPrize(HashMap<Integer, Integer> winResult) {
        float prize = 0.0f;
        for (LottoResultInform result : LottoResultInform.values()) {
            prize = prize + (float) result.getMoney() * winResult.get(result.getCount());
        }
        return prize;
    }


}
