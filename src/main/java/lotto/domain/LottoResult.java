package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lotto.constant.PriceConstant;

public class LottoResult {

    Map<Integer, Integer> resultMap;
    private int winningCount;

    private LottoResult() {
        this.resultMap = generateResultMap();
    }

    public static LottoResult from() {
        return new LottoResult();
    }

    private Map<Integer, Integer> generateResultMap() {
        resultMap = new ConcurrentHashMap<>();
        resultMap.put(PriceConstant.FIFTH_PLACE.getCount(), 0);
        resultMap.put(PriceConstant.FOURTH_PLACE.getCount(), 0);
        resultMap.put(PriceConstant.THIRD_PLACE.getCount(), 0);
        resultMap.put(PriceConstant.SECOND_PLACE.getCount(), 0);
        resultMap.put(PriceConstant.FIRST_PLACE.getCount(), 0);

        return resultMap;
    }

    public void countWinningCase(List<Lotto> lotteries, WinningLotto winningLotto) {
        for (Lotto lotto : lotteries) {
            winningCount = lotto.compareTo(winningLotto.getWinningLotto());
            countResultMap();
            countBonusNumber(lotto, winningLotto.getBonusNumber());
        }
    }

    private void countResultMap() {
        if (resultMap.containsKey(winningCount)) {
            resultMap.put(winningCount, resultMap.get(winningCount) + 1);
        }
    }

    private void countBonusNumber(Lotto lotto, int bonusNumber) {
        if (winningCount != PriceConstant.SECOND_PLACE.getCount()) {
            return;
        }

        if (lotto.isCompareByBonusNumber(bonusNumber)) {
            resultMap.put(PriceConstant.SECOND_PLACE.getCount(),
                    resultMap.get(PriceConstant.SECOND_PLACE.getCount()) + 1);
            resultMap.put(PriceConstant.THIRD_PLACE.getCount(),
                    resultMap.get(PriceConstant.THIRD_PLACE.getCount()) - 1);
        }
    }

    public Map<Integer, Integer> getResultMap() {
        return resultMap;
    }
}
