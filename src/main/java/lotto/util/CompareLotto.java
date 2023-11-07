package lotto.util;

import java.util.List;

public class CompareLotto {

    public int getCompareCount(List<Integer> lotto, List<Integer> winningNum) {
        int compareCount = 0;
        for (int number : winningNum) {
            if (lotto.contains(number)) {
                compareCount += 1;
            }
        }
        return compareCount;
    }

    public boolean getMatchBonus(List<Integer> lotto, int bonusNum) {
        if (lotto.contains(bonusNum)) {
            return true;
        }
        return false;
    }
}
