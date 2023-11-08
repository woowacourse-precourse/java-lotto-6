package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.Prize;

import java.util.List;

public class LottoService {

    public static Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public static int getMatchingCount(List<Integer> lotto, List<Integer> winningNumber) {
        int matchCount = 0;
        for(Integer i : lotto) {
            if(winningNumber.contains(i)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public static boolean getMatchingBonusNumber(int bonusNumber, List<Integer> winningNumber) {
        return winningNumber.contains(bonusNumber);
    }

    public static Prize getPrize(List<Integer> lotto, List<Integer> winningNumber, int bonusNumber) {
        int matchingCount = getMatchingCount(lotto, winningNumber);
        if(matchingCount == 6)
            return Prize.FIRST;
        if(matchingCount == 5){
            if(getMatchingBonusNumber(bonusNumber, winningNumber))
                return Prize.SECOND;
            return Prize.THIRD;
        }
        if(matchingCount == 4)
            return Prize.FOURTH;
        if(matchingCount == 3)
            return Prize.FIFTH;
        return Prize.NONE;
    }

}
