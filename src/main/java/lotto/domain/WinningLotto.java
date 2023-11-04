package lotto.domain;

import lotto.constant.LottoConstant;
import lotto.exception.ErrorMessage;
import lotto.exception.InvalidInputException;
import lotto.validator.NumberValidator;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank match(Lotto lotto) {
        int matchCount = lotto.match(winningNumbers);
        boolean matchBonus = lotto.contains(bonusNumber);
        return LottoRank.of(matchCount, matchBonus);
    }

    public void validate(Lotto winningNumbers, int bonusNumber) {
        validateBonusNumberDuplicate(winningNumbers, bonusNumber);
        validateBonusNumberRange(bonusNumber);
    }

    private void validateBonusNumberDuplicate(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new InvalidInputException(ErrorMessage.LOTTO_NUMBERS_DUPLICATE);
        }
    }

    private void validateBonusNumberRange(int bonusNumber) {
        NumberValidator.of(bonusNumber).shouldInRange(
                LottoConstant.LOTTO_NUMBER_MIN,
                LottoConstant.LOTTO_NUMBER_MAX,
                ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE
        );
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
