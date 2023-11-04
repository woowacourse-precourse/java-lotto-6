package lotto.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoBuyer;
import lotto.model.win.WinResult;

public class LottoChecker {
    private static final int BONUS_IS_USELESS = 0;
    private LottoBuyer lottoBuyer;
    private List<Integer> target;
    private final int bonus;

    public LottoChecker(LottoBuyer lottoBuyer, List<Integer> target, int bonus) {
        this.lottoBuyer = lottoBuyer;
        this.target = target;
        this.bonus = bonus;
    }

    public Map<WinResult, Integer> checkAllLotto() {
        Map<WinResult, Integer> map = new LinkedHashMap<>();
        Arrays.stream(WinResult.values())
                .filter(winResult -> !winResult.equals(WinResult.FAIL))
                .forEach(winResult -> map.put(winResult,0));

        for (int i = 0; i < lottoBuyer.size(); i++) {
            Lotto lotto = lottoBuyer.getLotto(i);

            int matchedCount = matchWithTarget(lotto);
            int bonusCount = matchWithBonus(lotto, matchedCount);

            WinResult result = getResult(matchedCount, bonusCount);
            if(result.equals(WinResult.FAIL)) {
                continue;
            }
            Integer savedNumber = map.getOrDefault(result, 0);
            map.put(result, ++savedNumber);
        }
        return map;
    }
    private WinResult getResult (int matchedCount, int bonusCount) {
        return Arrays.stream(WinResult.values())
                .filter(winResult -> winResult.matchedCount == matchedCount)
                .filter(winResult -> winResult.bonusCount == bonusCount)
                .findAny()
                .orElse(WinResult.FAIL);
    }

    private int matchWithTarget(Lotto lotto) {
        return (int) lotto.stream()
                .filter(num -> target.contains(num))
                .count();
    }

    private int matchWithBonus(Lotto lotto, int matchedCount) {
        if(matchedCount == WinResult.THIRD.matchedCount) {
            return (int) lotto.stream()
                    .filter(num -> bonus == num)
                    .count();
        }
        return BONUS_IS_USELESS;
    }
}
