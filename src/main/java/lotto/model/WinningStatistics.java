package lotto.model;

import lotto.constant.BonusStatus;
import lotto.constant.Constant;

import java.util.*;

public class WinningStatistics {
    private static final int SPECIAL_MATCH_COUNT = Constant.SPECIAL_MATCH_COUNT.getValue();
    private long totalReward = 0;
    private double rateOfReturn = 0.0;
    private final Map<WinningPrize, Integer> winningResult = new HashMap<>() {{
        put(WinningPrize.FIRST_PRIZE, 0);
        put(WinningPrize.SECOND_PRIZE, 0);
        put(WinningPrize.THIRD_PRIZE, 0);
        put(WinningPrize.FOURTH_PRIZE, 0);
        put(WinningPrize.FIFTH_PRIZE, 0);
    }};

    WinningStatistics(List<Lotto> purchaseLottos, List<Integer> winningLotto, int bonusNumber) {
        setWinningResult(purchaseLottos, winningLotto, bonusNumber);
        setRateOfReturn();
    }

    private void setWinningResult(List<Lotto> purchaseLottos, List<Integer> winningLotto, int bonusNumber) {
        for (Lotto purchaseLotto : purchaseLottos) {
            List<Integer> lotto = purchaseLotto.getNumbers();
            int matchCount = calculateMatchCount(lotto, winningLotto);
            BonusStatus bonusStatus = getBonusStatus(matchCount, lotto, bonusNumber);
            Optional<WinningPrize> winningPrize = WinningPrize.getWinningPrize(matchCount, bonusStatus);
            if (winningPrize.isPresent()) {
                winningResult.put(winningPrize.get(), winningResult.get(winningPrize) + 1);
                totalReward += winningPrize.get().getReward();
            }
        }
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

    private void setRateOfReturn() {

    }
}
