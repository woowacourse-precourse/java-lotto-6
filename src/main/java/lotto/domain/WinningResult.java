package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.domain.WinningStatistics.*;

public class WinningResult {
    private static WinningStatistics winningStatistics;

    public static List<Integer> calculateWinningCount(Lottos purchaseLottos, Lotto winningLotto) {
        List<Integer> counts = new ArrayList<>();
        for(List<Integer> purchaseLotto : purchaseLottos.getLottos()) {
            int count = (int)purchaseLotto.stream().filter(winningLotto.getNumbers()::contains).count();
            counts.add(count);
        }
        return counts;
    }

    public static double calculateWinningRate(Lottos purchaseLottos, Lotto winningLotto, BonusNumber bonusNumber) {
        WinningStatistics statistics = calculateWinningResult(purchaseLottos, winningLotto, bonusNumber);

        return 0;
    }

    private static WinningStatistics calculateWinningResult(Lottos purchaseLottos, Lotto winningLotto, BonusNumber bonusNumber) {
        final List<Integer> winningCount = calculateWinningCount(purchaseLottos, winningLotto);
        boolean bonus = false;

        for (Integer integer : winningCount) {
            if (integer == BONUS_NUMBER_CONDITION) {
                bonus = isContainBonusNumber(purchaseLottos, bonusNumber);
            }
        }
        return getRank(winningCount, bonus);
    }

    private static WinningStatistics getRank(List<Integer> winningCount, boolean bonus) {
        return Arrays.stream(values())
                .filter(statistics -> statistics.getMatchCount() == winningCount)
                .filter(statistics -> statistics.isContainBonus() == bonus)
                .findAny()
                .orElse(NOTHING);
    }

    private static boolean isContainBonusNumber(Lottos purchaseLottos, BonusNumber bonusNumber) {
        for(List<Integer> purchaseLotto : purchaseLottos.getLottos()) {
            if(purchaseLotto.contains(bonusNumber.getBonusNumber())) {
                return true;
            }
        }
        return false;
    }
}
