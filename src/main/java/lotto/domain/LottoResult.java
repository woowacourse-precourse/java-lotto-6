package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lotto.constant.PriceConstant;

public class LottoResult {

    Lotteries lotteries;
    WinningLotto winningLotto;
    Map<Integer, Integer> resultMap = new ConcurrentHashMap<>();

    private LottoResult(Lotteries lotteries, WinningLotto winningLotto) {
        this.lotteries = lotteries;
        this.winningLotto = winningLotto;
        this.resultMap = generateResultMap();
    }

    public static LottoResult of(Lotteries lotteries, WinningLotto winningLotto) {
        return new LottoResult(lotteries, winningLotto);
    }

    private Map<Integer, Integer> generateResultMap() {
        resultMap.put(PriceConstant.FIFTH_PLACE.getCount(), 0);
        resultMap.put(PriceConstant.FOURTH_PLACE.getCount(), 0);
        resultMap.put(PriceConstant.THIRD_PLACE.getCount(), 0);
        resultMap.put(PriceConstant.SECOND_PLACE.getCount(), 0);
        resultMap.put(PriceConstant.FIRST_PLACE.getCount(), 0);

        return resultMap;
    }
}
