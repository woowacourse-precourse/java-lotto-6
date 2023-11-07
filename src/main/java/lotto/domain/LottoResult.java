package lotto.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.PriceConstant;

public class LottoResult {

    private static final Double PERCENTAGE = 100.0;
    private Map<String, Integer> resultMap;
    private int winningCount;

    private LottoResult() {
        this.resultMap = generateResultMap();
    }

    public static LottoResult from() {
        return new LottoResult();
    }

    private Map<String, Integer> generateResultMap() {
        resultMap = new LinkedHashMap<>();
        resultMap.put(PriceConstant.FIFTH_PLACE.getLabel(), 0);
        resultMap.put(PriceConstant.FOURTH_PLACE.getLabel(), 0);
        resultMap.put(PriceConstant.THIRD_PLACE.getLabel(), 0);
        resultMap.put(PriceConstant.SECOND_PLACE.getLabel(), 0);
        resultMap.put(PriceConstant.FIRST_PLACE.getLabel(), 0);

        return resultMap;
    }

    public void countWinningCase(List<Lotto> lotteries, WinningLotto winningLotto) {
        for (Lotto lotto : lotteries) {
            winningCount = lotto.compareTo(winningLotto.getWinningLotto());
            countResultMap(winningCount);
            countBonusNumber(lotto, winningLotto.getBonusNumber().getNumber());
        }
    }

    private void countResultMap(int winningCount) {
        if (winningCount == PriceConstant.FIFTH_PLACE.getCount()) {
            resultMap.put(PriceConstant.FIFTH_PLACE.getLabel(), resultMap.get(PriceConstant.FIFTH_PLACE.getLabel()) + 1);
        }
        if (winningCount == PriceConstant.FOURTH_PLACE.getCount()) {
            resultMap.put(PriceConstant.FOURTH_PLACE.getLabel(), resultMap.get(PriceConstant.FOURTH_PLACE.getLabel()) + 1);
        }
        if (winningCount == PriceConstant.FIRST_PLACE.getCount()) {
            resultMap.put(PriceConstant.FIRST_PLACE.getLabel(), resultMap.get(PriceConstant.FIRST_PLACE.getLabel()) + 1);
        }
    }

    private void countBonusNumber(Lotto lotto, int bonusNumber) {
        if (winningCount != PriceConstant.THIRD_PLACE.getCount()) {
            return;
        }

        if (lotto.isCompareByBonusNumber(bonusNumber)) {
            resultMap.put(PriceConstant.SECOND_PLACE.getLabel(),
                    resultMap.get(PriceConstant.SECOND_PLACE.getLabel()) + 1);
            return;
        }

        resultMap.put(PriceConstant.THIRD_PLACE.getLabel(),
                resultMap.get(PriceConstant.THIRD_PLACE.getLabel()) + 1);
    }

    public Map<String, Integer> getResultMap() {
        return Collections.unmodifiableMap(resultMap);
    }

    public double calculateEarningRate(int purchaseAmount) {
        int totalEarning = calculateTotalEarning();
        if (totalEarning == 0) {
            return 0;
        }

        return (double) totalEarning / (double) purchaseAmount * PERCENTAGE;
    }

    private int calculateTotalEarning() {
        return resultMap.keySet().stream()
                .mapToInt(key -> PriceConstant.getPriceByLabel(key) * resultMap.get(key))
                .sum();
    }
}
