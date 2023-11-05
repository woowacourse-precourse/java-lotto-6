package lotto.domain;

import static lotto.utils.validator.LottoNumberValidator.validateDuplicateBonusNumber;
import static lotto.utils.validator.LottoNumberValidator.validateDuplicateNumbers;
import static lotto.utils.validator.LottoNumberValidator.validateOutOfRange;

import java.util.List;

public class WinningNumbers {

    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    public WinningNumbers(List<Integer> winningNumber, int bonusNumber) {
        validateOutOfRange(winningNumber);
        validateOutOfRange(bonusNumber);
        validateDuplicateNumbers(winningNumber);
        validateDuplicateBonusNumber(winningNumber, bonusNumber);
        this.winningNumber = new WinningNumber(winningNumber);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    public LottoResults calculateLottoResult(Lotto lotto) {
        int correctCount = winningNumber.calculateCorrectNumberCount(lotto);
        boolean hasBonus = bonusNumber.hasBonus(lotto);
        return LottoResults.getLottoResult(correctCount, hasBonus);
    }
}
