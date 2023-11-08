package lotto;

import java.util.List;


public class Score {

    public static int checkWinningNumber(Lotto lotto, List<Integer> winningNumber){
        int countOfMatch=0;
        List<Integer> randomNum = lotto.getNumbers(lotto);
        for(Integer eachNum : randomNum) {
            if(winningNumber.contains(eachNum)) countOfMatch++;
        }
        return countOfMatch;
    }

    public static boolean checkBonusNumber(Lotto lotto, int bonusNumber){
        return lotto.getNumbers(lotto).contains(bonusNumber);
    }

}
