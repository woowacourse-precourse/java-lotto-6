package lotto.util;

import java.util.List;

public class CompareNumber {
    public int compareWinnerNum(List<Integer> userWin, List<Integer> randomWin) {
        int sameCount = 0;
        for (Integer number : userWin) {
            if (randomWin.contains(number)) {
                sameCount++;
            }
        }
        return sameCount;
    }

    public boolean compareBonusNum(int bonusNumber, List<Integer> randomWin) {
        int bonusCount = 0;
        return randomWin.contains(bonusNumber);
    }

}
