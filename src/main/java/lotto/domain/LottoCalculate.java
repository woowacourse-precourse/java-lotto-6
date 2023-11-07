package lotto.domain;

import java.util.List;
import lotto.view.ValidationView;

public class LottoCalculate {
    private static final int LOTTO_PRICE = 1000;

    public static int calcAmount(int money){
        return money/LOTTO_PRICE;
    }

    public static int getMatchCount(List<Integer> lotto, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : lotto) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public static boolean checkMatchBonus(List<Integer> lotto, int bonusNumber) {
        return lotto.contains(bonusNumber);
    }

    public static Rank checkValue(int matchCount, boolean matchBonus) {
        return Rank.valueOf(matchCount, matchBonus);
    }

}
