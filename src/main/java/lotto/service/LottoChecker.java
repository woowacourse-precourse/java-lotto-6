package lotto.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lotto.lotto.Lotto;
import lotto.lotto.LottoBuyer;
import lotto.lotto.win.WinResult;

public class LottoChecker {
    private static final int USELESS_BONUS = 0;
    LottoBuyer lottoBuyer;
    List<Integer> target;
    int bonus;

    public LottoChecker(LottoBuyer lottoBuyer) {
        this.lottoBuyer = lottoBuyer;
    }

    public Map<Optional<WinResult>, Integer> checkAllLotto() {
        Map<Optional<WinResult>, Integer> map = new HashMap<Optional<WinResult>, Integer>();

        for (int i = 0; i < lottoBuyer.size(); i++) {
            Lotto lotto = lottoBuyer.getLotto(i);

            int matchedCount = matchWithTarget(lotto);
            int bonusCount = matchWithBonus(lotto, matchedCount);

            Optional<WinResult> result = getResult(matchedCount, bonusCount);
            Integer savedNumber = map.getOrDefault(result, 0);
            map.put(result, ++savedNumber);
        }
        return map;
    }
    private Optional<WinResult> getResult (int matchedCount, int bonusCount) {
        return Arrays.stream(WinResult.values())
                .filter(winResult -> winResult.matchedCount == matchedCount)
                .filter(winResult -> winResult.bonusCount == bonusCount)
                .findAny();
    }

    private int matchWithTarget(Lotto lotto) {
        return (int) lotto.streamNumbers()
                .filter(num -> target.contains(num))
                .count();
    }

    private int matchWithBonus(Lotto lotto, int matchedCount) {
        if(matchedCount == WinResult.THIRD.matchedCount) {
            return (int) lotto.streamNumbers()
                    .filter(num -> bonus == num)
                    .count();
        }
        return USELESS_BONUS;
    }
}
