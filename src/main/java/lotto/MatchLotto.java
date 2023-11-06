package lotto;

import java.util.ArrayList;
import java.util.List;

public class MatchLotto {



    public static int isNumbersMatching(Lotto winningnumbers, List<Integer> numbers) {
        int count = 0;
        for (Integer winningNum : winningnumbers.getWinningNumbers()) {
            if (numbers.contains(winningNum)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isBonusNumbersMatching(int bonusNumber, List<Integer> numbers) {
        if (numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }


}