package lotto.domain;

import lotto.domain.convertor.BonusNumberConvertor;
import lotto.domain.convertor.Convertor;
import lotto.domain.validator.BonusNumberValidator;
import lotto.domain.validator.Validator;


public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(String bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = convertBonusNumber(bonusNumber);
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    private void validateBonusNumber(String bonus) {
        Validator<String> validator = new BonusNumberValidator();
        validator.validate(bonus);
    }

    private int convertBonusNumber(String bonus) {
        Convertor<String, Integer> bonusNumberConvertor = new BonusNumberConvertor();
        return bonusNumberConvertor.convert(bonus);
    }
}
