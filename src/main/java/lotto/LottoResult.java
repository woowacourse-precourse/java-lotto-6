package lotto;

import lotto.enums.LottoPrize;

import java.util.List;

import static lotto.enums.LottoPrize.MATCH_5;
import static lotto.enums.LottoPrize.MATCH_5_BONUS;

public class LottoResult {
    private int count;
    private boolean bonus;
    public LottoResult(List<Integer> myLotto, Lotto lotto, int bonus) {
        this.count = setCount(myLotto, lotto);
        this.bonus = setBonus(myLotto, bonus);
    }

    public LottoPrize lottoResultToLottoPrize() {
        if (count == 5) {
            if (bonus) {
                return MATCH_5_BONUS;
            }
            return MATCH_5;
        }
        for (LottoPrize lottoPrize: LottoPrize.values()) {
            if (count == lottoPrize.getMatchingNumbers()) {
                return lottoPrize;
            }
        }
        return null;
    }

    private int setCount(List<Integer> myLotto, Lotto lotto) {
        return myLotto.stream().mapToInt(i -> {
            if (lotto.isInclude(i)) {
                return 1;
            }
            return 0;
        }).sum();
    }

    private boolean setBonus(List<Integer> myLotto, int bonus) {
        return myLotto.contains(bonus);
    }

    public int getCount() {
        return count;
    }

    public boolean getBonus() {
        return bonus;
    }
}
