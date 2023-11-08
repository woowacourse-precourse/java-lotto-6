package lotto.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.PriceConstant;

public class LottoResult {

    private static final Double PERCENTAGE = 100.0;

    private Map<String, Integer> winningResult;
    private int winningCount;

    private LottoResult() {
        this.winningResult = generateResultMap();
    }

    public static LottoResult from() {
        return new LottoResult();
    }

    private Map<String, Integer> generateResultMap() {
        winningResult = new LinkedHashMap<>();
        winningResult.put(PriceConstant.FIFTH_PLACE.getLabel(), 0);
        winningResult.put(PriceConstant.FOURTH_PLACE.getLabel(), 0);
        winningResult.put(PriceConstant.THIRD_PLACE.getLabel(), 0);
        winningResult.put(PriceConstant.SECOND_PLACE.getLabel(), 0);
        winningResult.put(PriceConstant.FIRST_PLACE.getLabel(), 0);

        return winningResult;
    }

    public void countWinningCase(List<Lotto> lotteries, WinningLotto winningLotto) {
        for (Lotto lotto : lotteries) {
            winningCount = lotto.compareTo(winningLotto.getWinningLotto());
            boolean isMatchBonusNumber = isMatchBonusNumber(lotto, winningLotto.getBonusNumber().getNumber());
            countResultMap(winningCount, isMatchBonusNumber);
        }
    }

    private void countResultMap(int winningCount, boolean isMatchBonusNumber) {
        PriceConstant priceConstant = PriceConstant.countWinningPlace(winningCount, isMatchBonusNumber);
        if (priceConstant != null) {
            winningResult.put(priceConstant.getLabel(), winningResult.get(priceConstant.getLabel()) + 1);
        }
    }

    private boolean isMatchBonusNumber(Lotto lotto, int bonusNumber) {
        if (lotto.isCompareByBonusNumber(bonusNumber)) {
            return true;
        }
        return false;
    }

    public Map<String, Integer> getWinningResult() {
        return Collections.unmodifiableMap(winningResult);
    }

    public double calculateEarningRate(int purchaseAmount) {
        int totalEarning = calculateTotalEarning();
        if (totalEarning == 0) {
            return 0;
        }
        return (double) totalEarning / (double) purchaseAmount * PERCENTAGE;
    }

    private int calculateTotalEarning() {
        return winningResult.keySet().stream()
                .mapToInt(key -> PriceConstant.getPriceByLabel(key) * winningResult.get(key))
                .sum();
    }
}
