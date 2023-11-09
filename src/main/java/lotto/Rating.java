package lotto;

import java.util.List;

public class Rating {
    private final static Integer INITIALIZATION_COUNT = 0;
    private final static Integer COUNT_INCREMENT = 1;
    private final static boolean TRUE = true;
    private final static boolean FALSE = false;

    public static Rankings ranking(List<Integer> lotto, List<Integer> winNumbers, Integer bonusNumber) {
        Integer winNumberCount = INITIALIZATION_COUNT;
        boolean needBonusBall = FALSE;
        for(Integer number : lotto) {
            if(winNumbers.contains(number)) {
                winNumberCount += COUNT_INCREMENT;
            }
        }

        if(lotto.contains(bonusNumber)) {
            needBonusBall = TRUE;
        }

        return Rankings.getRanking(winNumberCount, needBonusBall);
    }
}