package lotto;

import java.util.ArrayList;
import java.util.List;

public class HitLottoNumber {
    public static int hitLottoNumber(List<Integer> lotto, ArrayList<Integer> prizeNumberArray, int bonusIntNumber) { // 로또와 당첨 번호를 비교하여 등수를 확인한다
        int prizeSum = countMatchingNumbers(lotto, prizeNumberArray); // 동일한 숫자의 개수를 리턴
        if (prizeSum == 3) { // 3개의 숫자가 동일하면 5등이므로 5를 리턴
            return 5;
        }
        if (prizeSum == 4) { // 4개의 숫자가 동일하면 4등이므로 4를 리턴
            return 4;
        }
        if (prizeSum == 5) { // 5개의 숫자가 동일하면 2등 또는 3등이므로 이를 확인한 뒤 리턴
            return checkWinWithBonus(lotto, bonusIntNumber); // 보너스 번호가 존재하면 2를 리턴, 그렇지 않으면 3을 리턴
        }
        if (prizeSum == 6) { // 6개의 숫자가 동일하면 1등이므로 1을 리턴
            return 1;
        }
        return 0; // 동일한 숫자가 2 이하이면 0을 리턴
    }
    public static int countMatchingNumbers(List<Integer> lotto, ArrayList<Integer> prizeNumberArray) { // 로또와 당첨 번호에 동일하게 존재하는 숫자의 개수를 확인한다
        int prizeSum = 0;
        for (int prizeNumber : prizeNumberArray) { // 당첨 번호의 숫자를 순회하며
            if (lotto.contains(prizeNumber)) { // 로또에 존재하는 번호라면
                prizeSum++; // +1
            }
        }
        return prizeSum; // 동일한 숫자의 개수를 리턴
    }

    public static int checkWinWithBonus(List<Integer> lotto, int bonusIntNumber) { // 보너스 번호의 일치 여부를 확인한다
        if (lotto.contains(bonusIntNumber)) { // 보너스 번호가 로또에 존재하면 2를 리턴
            return 2;
        }
        return 3; // 존재하지 않으면 3을 리턴
    }
}
