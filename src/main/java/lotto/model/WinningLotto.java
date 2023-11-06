package lotto.model;

import java.util.List;
import lotto.model.enums.Prize;
import lotto.model.exception.WinningLottoException;

public class WinningLotto {
    private final Lotto winningLotto;
    private final String userBonusNumber;

    public WinningLotto(Lotto winningLotto, String userBonusNumber) {
        int bonusNumber = isValidBonusNumber(userBonusNumber, winningLotto.getNumbers());
        this.userBonusNumber = String.valueOf(bonusNumber);
        this.winningLotto = winningLotto;
    }

    public Prize calculatePrize(Lotto userLotto) {
        int matchCount = userLotto.countMatchNumbers(winningLotto);
        boolean bonusMatch = userLotto.hasBonusNumber(String.valueOf(userBonusNumber));
        return determinePrize(matchCount, bonusMatch);
    }

    public int isValidBonusNumber(String userBonusNumber, List<Integer> winningNumbers) {
        int bonusNumber = getBonusIntegerNumber(userBonusNumber);
        WinningLottoException.checkBonusNumberIntegerExceptions(winningNumbers, bonusNumber);
        return bonusNumber;
    }

    private static int getBonusIntegerNumber(String userBonusNumber) {
        WinningLottoException.checkBonusNumberTypeException(userBonusNumber);
        return Integer.parseInt(userBonusNumber.trim());
    }

    private Prize determinePrize(int matchCount, boolean bonusMatch) {
        for (Prize prize : Prize.values()){
            if (prize.getMatchCount() == matchCount && prize.isBonusMatch() == bonusMatch) {
                return prize;
            }
        }
        return Prize.NONE;
    }
}
