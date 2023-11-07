package lotto.util;

import java.util.List;

public class CompareNumber {

    public int compareWinnerNum(List<Integer> userWin, List<Integer> randomWin) {
        int count = 0;
        for (Integer number : userWin){
            if(randomWin.contains(number)){
                count++;
            }
        }
        return count;
    }
}
