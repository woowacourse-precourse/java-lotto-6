package lotto;

import java.util.Collections;
import java.util.List;


public class Score {
    static int countOfMatch=0;
    static boolean bonusCheck;

    public static int checkWinningNumber(Lotto lotto, List<Integer> winningNumber){
        countOfMatch = Collections.frequency(lotto.getNumbers(lotto), winningNumber);
        return countOfMatch;
    }

    public static boolean checkBonusNumber(Lotto lotto, int bonusNumber){
        bonusCheck = lotto.getNumbers(lotto).contains(bonusNumber);
        return bonusCheck;
    }

}
