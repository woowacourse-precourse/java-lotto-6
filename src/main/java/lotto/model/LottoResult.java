package lotto.model;

import static lotto.util.ConstantList.MONEY_EACH_GRADE;
import static lotto.util.ConstantNumbers.LOTTO_GRADE_QUANTITY;

import java.util.Map;

public class LottoResult {

    private final Map<Integer, Integer> lottoResult;

    private LottoResult (Map<Integer, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public static LottoResult of (Map<Integer, Integer> lottoResult) {
        return new LottoResult(lottoResult);
    }

    public Integer getValue (Integer key) {
        return lottoResult.get(key);
    }

    public Integer calculateTotal () {
        int total = 0;

        for (int i = 0; i < LOTTO_GRADE_QUANTITY.getConstant(); i++) {

            total += (Integer) MONEY_EACH_GRADE.getConstant().get(i)
                    * lottoResult.get(i);

        }

        return total;
    }
}
