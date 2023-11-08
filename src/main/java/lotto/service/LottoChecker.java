package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.WinningLotto;

public class LottoChecker {

    public Prize checkPrize(Lotto lotto, WinningLotto winningLotto) {
        List<Integer> userNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getWinningLotto().getNumbers();
        int bonusNumber = winningLotto.getBonusNumber().getBonusNumber();

        int matchingNumbers = countMatchingNumbers(userNumbers, winningNumbers);
        boolean hasBonusNumber = hasBonusNumber(userNumbers, bonusNumber);

        return calculatePrize(matchingNumbers, hasBonusNumber);
    }

    private int countMatchingNumbers(List<Integer> userNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int userNumber : userNumbers) {
            if (winningNumbers.contains(userNumber)) {
                count++;
            }
        }
        return count;
    }

    private boolean hasBonusNumber(List<Integer> userNumbers, int bonusNumber) {
        return userNumbers.contains(bonusNumber);
    }

    private static Prize calculatePrize(int matchingNumbers, boolean hasBonusNumber) {
        if (matchingNumbers == 6) {return Prize.FIRST;}
        if (matchingNumbers == 5 && hasBonusNumber) {return Prize.SECOND;}
        if (matchingNumbers == 5) {return Prize.THIRD;}
        if (matchingNumbers == 4) {return Prize.FOURTH;}
        if (matchingNumbers == 3) {return Prize.FIFTH;}

        return Prize.NONE;
    }

}
