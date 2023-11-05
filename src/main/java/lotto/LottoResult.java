package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private Map<WinningCriteria, Integer> result = new EnumMap<>(WinningCriteria.class);

    public LottoResult() {
        for (WinningCriteria criteria : WinningCriteria.values()) {
            result.put(criteria, 0);
        }
    }

    public void addWin(WinningCriteria criteria) {
        result.merge(criteria, 1, Integer::sum);
    }

    public int getCount(WinningCriteria criteria) {
        return result.get(criteria);
    }

    public double getRoundedReturn(double userPurchaseAmount, LottoResult lottoResult) {
        int totalPrice = lottoResult.getCount(WinningCriteria.FIFTH_PLACE) * 5_000 +
                lottoResult.getCount(WinningCriteria.FOURTH_PLACE) * 50_000 +
                lottoResult.getCount(WinningCriteria.THIRD_PLACE) * 1_500_000 +
                lottoResult.getCount(WinningCriteria.SECOND_PLACE) * 30_000_000 +
                lottoResult.getCount(WinningCriteria.FIRST_PLACE) * 2_000_000_000;
        double totalReturn = ((double) totalPrice / userPurchaseAmount) * 100.0;
        double roundedReturn = Math.round(totalReturn * 10.0) / 10.0;
        return roundedReturn;
    }

    public WinningCriteria getWinningCriteria(Lotto lotto, List<Integer> winningNumber, int bonusNumber) {
        int matchCount = lotto.countMatches(winningNumber);
        boolean bonus = lotto.additionalNumber(bonusNumber);
        if (matchCount == 6) return WinningCriteria.FIRST_PLACE;
        if (matchCount == 5 && bonus) return WinningCriteria.SECOND_PLACE;
        if (matchCount == 5) return WinningCriteria.THIRD_PLACE;
        if (matchCount == 4) return WinningCriteria.FOURTH_PLACE;
        if (matchCount == 3) return WinningCriteria.FIFTH_PLACE;

        return null;
    }
}
