package lotto.model;

import lotto.constant.Constants;

import java.util.*;

public class WinningStatistics {
    private static final int SPECIAL_MATCH_COUNT = Constants.SPECIAL_MATCH_COUNT.getValue();
    private long totalReward = 0;
    private double rateOfReturn = 0.0;
    private final Map<WinningPrize, Integer> winningResult = new LinkedHashMap<>() {{
        put(WinningPrize.FIFTH_PRIZE, 0);
        put(WinningPrize.FOURTH_PRIZE, 0);
        put(WinningPrize.THIRD_PRIZE, 0);
        put(WinningPrize.SECOND_PRIZE, 0);
        put(WinningPrize.FIRST_PRIZE, 0);
    }};

    public Map<WinningPrize, Integer> getWinningResult() {
        return winningResult;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    public void setWinningResult(List<Lotto> purchaseLottos, List<Integer> winningLotto, int bonusNumber) {
        for (Lotto purchaseLotto : purchaseLottos) {
            List<Integer> lotto = purchaseLotto.getNumbers();
            int matchCount = calculateMatchCount(lotto, winningLotto);
            BonusStatus bonusStatus = getBonusStatus(matchCount, lotto, bonusNumber);
            Optional<WinningPrize> winningPrizeOrNull = WinningPrize.getWinningPrize(matchCount, bonusStatus);
            if (winningPrizeOrNull.isPresent()) {
                WinningPrize winningPrize = winningPrizeOrNull.get();
                winningResult.put(winningPrize, winningResult.get(winningPrize) + 1);
                totalReward += winningPrize.getReward();
            }
        }
    }

    public void setRateOfReturn(int purchaseAmount) {
        rateOfReturn = (double) totalReward / purchaseAmount * 100;
    }

    private int calculateMatchCount(List<Integer> purchaseLotto, List<Integer> winningLotto) {
        return (int) purchaseLotto.stream().filter(winningLotto::contains).count();
    }

    private BonusStatus getBonusStatus(int matchCount, List<Integer> lotto, int bonusNumber) {
        if (matchCount != SPECIAL_MATCH_COUNT) {
            return BonusStatus.NO_MATTER;
        }
        if (lotto.contains(bonusNumber)) {
            return BonusStatus.IS_IN_LOTTO;
        }
        return BonusStatus.IS_NOT_IN_LOTTO;
    }
}
