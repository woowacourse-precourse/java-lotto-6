package lotto.domain;

import lotto.domain.convertor.BonusNumberConvertor;
import lotto.domain.convertor.Convertor;
import lotto.domain.validator.BonusNumberValidator;


public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(String bonusNumber, WinnerNumbers winnerNumbers) {
        validateBonusNumber(bonusNumber, winnerNumbers);
        this.bonusNumber = convertBonusNumber(bonusNumber);
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    private void validateBonusNumber(String bonus, WinnerNumbers winnerNumbers) {
        BonusNumberValidator validator = new BonusNumberValidator();
        validator.validate(bonus);
        validator.validateDuplicateWinnerNumber(convertBonusNumber(bonus), winnerNumbers);
    }

    private int convertBonusNumber(String bonus) {
        Convertor<String, Integer> bonusNumberConvertor = new BonusNumberConvertor();
        return bonusNumberConvertor.convert(bonus);
    }
}
