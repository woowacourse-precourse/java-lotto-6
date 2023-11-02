package lotto.domain;

import java.util.List;

import static lotto.exception.ExceptionMessage.LottoMachineException.BONUS_NUMBER_MUST_BE_UNIQUE;

public class WinningLottoHolder {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    private WinningLottoHolder(final Lotto winningLotto, final BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLottoHolder drawWinningLotto(final List<Integer> winningNumbers, final int bonusNumber) {
        validateBonusNumberIsDuplicate(winningNumbers, bonusNumber);
        return new WinningLottoHolder(Lotto.create(winningNumbers), BonusNumber.create(bonusNumber));
    }

    private static void validateBonusNumberIsDuplicate(final List<Integer> winningNumbers, final int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_MUST_BE_UNIQUE.message);
        }
    }

    public int calculateLottoMatchCount(final Lotto userLotto) {
        return winningLotto.calculateMatchCount(userLotto);
    }

    public boolean isBonusNumberInclude(final Lotto userLotto) {
        return userLotto.isNumberInclude(bonusNumber.getValue());
    }

    public List<Integer> getWinningLotteryNumbers() {
        return winningLotto.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber.getValue();
    }
}
