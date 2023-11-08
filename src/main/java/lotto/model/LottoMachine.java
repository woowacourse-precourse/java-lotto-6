package lotto.model;

import java.util.List;

public class LottoMachine {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoMachine(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public String getWinner(Lotto lotto) {
        int sameNumber = getNumberSameWithWinningNumbers(lotto);
        boolean hasBonus = hasSameNumberWithBonusNumber(lotto);
        if (sameNumber == 3) {
            return "5등";
        }
        if (sameNumber == 4) {
            return "4등";
        }
        if (sameNumber == 5 && hasBonus) {
            return "2등";
        }
        if (sameNumber == 5) {
            return "3등";
        }
        if (sameNumber == 6) {
            return "1등";
        }
        return "꽝";
    }

    private int getNumberSameWithWinningNumbers(Lotto lotto) {
        int sameNumber = 0;
        List<Integer> lottoNumbers = lotto.getNumbers();
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                sameNumber += 1;
            }
        }
        return sameNumber;
    }

    private boolean hasSameNumberWithBonusNumber(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        for (int number : lottoNumbers) {
            if (bonusNumber == number) {
                return true;
            }
        }
        return false;
    }


}
