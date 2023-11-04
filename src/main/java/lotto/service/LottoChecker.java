package lotto.service;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoBuyer;
import lotto.model.win.Rank;

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

    public Map<Rank, Integer> checkAllLotto() {
        Map<Rank, Integer> map = new LinkedHashMap<>();
        Arrays.stream(Rank.values())
                .filter(winResult -> !winResult.equals(Rank.FAIL))
                .forEach(winResult -> map.put(winResult,0));

        for (int i = 0; i < lottoBuyer.size(); i++) {
            Lotto lotto = lottoBuyer.getLotto(i);

            int matchedCount = matchWithTarget(lotto);
            int bonusCount = matchWithBonus(lotto, matchedCount);

            Rank result = getResult(matchedCount, bonusCount);
            if(result.equals(Rank.FAIL)) {
                continue;
            }
            Integer savedNumber = map.getOrDefault(result, 0);
            map.put(result, ++savedNumber);
        }
        return map;
    }
    private Rank getResult (int matchedCount, int bonusCount) {
        return Arrays.stream(Rank.values())
                .filter(winResult -> winResult.matchedCount == matchedCount)
                .filter(winResult -> winResult.bonus == bonusCount)
                .findAny()
                .orElse(Rank.FAIL);
    }

    private int matchWithTarget(Lotto lotto) {
        return (int) lotto.stream()
                .filter(num -> target.contains(num))
                .count();
    }

    private int matchWithBonus(Lotto lotto, int matchedCount) {
        if(matchedCount == Rank.THIRD.matchedCount) {
            return (int) lotto.stream()
                    .filter(num -> bonus == num)
                    .count();
        }
        return BONUS_IS_USELESS;
    }
}
