package lotto.model;

import static lotto.constant.ErrorMessage.BONUS_NUMBER_DUPLICATED_WINNING_NUMBERS;
import static lotto.constant.ErrorMessage.NOT_IN_RANGE_LOTTO_NUMBER;
import static lotto.constant.LottoGameConfig.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoGameConfig.MIN_LOTTO_NUMBER;

import lotto.constant.LottoRanking;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    private WinningLotto(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        validateBonusNumberDuplicatedWinningNumbers(winningNumbers, bonusNumber);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto createWinningLotto(Lotto winningNumbers, int bonusNumber) {
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private void validateBonusNumberDuplicatedWinningNumbers(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.isLottoContainsNumber(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATED_WINNING_NUMBERS.toString());
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        if (isBonusNumberInWrongRange(bonusNumber)) {
            throw new IllegalArgumentException(NOT_IN_RANGE_LOTTO_NUMBER.toString());
        }
    }

    private boolean isBonusNumberInWrongRange(int bonusNumber) {
        return bonusNumber < MIN_LOTTO_NUMBER.getValue()
                || bonusNumber > MAX_LOTTO_NUMBER.getValue();
    }

    public LottoRanking calculateLottoRanking(Lotto onwerLotto) {
        return LottoRanking.convertLottoIntoLottoRanking(
                onwerLotto.calculateSameNumbers(winningNumbers),
                onwerLotto.isLottoContainsNumber(bonusNumber)
        );
    }
}
