package lotto;

import java.util.ArrayList;
import java.util.List;

public class MatchLotto {

    /**
     * 해당 로또가 몇개 맞았는지 return 합니다.
     * @param winningnumbers 당첨번호입니다.
     * @param numbers 사용가자 구매한 로또입니다.
     * @return 해당 로또가 몇개를 맞추었는지 return 합니다.
     */
    public static int isNumbersMatching(Lotto winningnumbers, List<Integer> numbers) {
        int count = 0;
        for (Integer winningNum : winningnumbers.getWinningNumbers()) {
            if (numbers.contains(winningNum)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 보너스 번호가 맞았는지 체크합니다.
     * @param bonusNumber 보너스 번호입니다.
     * @param numbers 사용자가 구매한 번호입니다.
     * @return 맞추었는지 맞추지않았는지 boolean을 return 합니다.
     */
    public static boolean isBonusNumbersMatching(int bonusNumber, List<Integer> numbers) {
        if (numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }


}