package lotto.domain;

import static lotto.utils.validator.LottoNumberValidator.validateDuplicate;

public class WinningNumbers {

    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    public WinningNumbers(WinningNumber winningNumber, BonusNumber bonusNumber) {
        validateDuplicate(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public LottoResults calculateLottoResult(Lotto lotto) {
        int correctCount = winningNumber.calculateCorrectNumberCount(lotto);
        boolean hasBonus = bonusNumber.hasBonus(lotto);
        return LottoResults.getLottoResult(correctCount, hasBonus);
    }
}
