package lotto.service;

import lotto.model.domain.Bonus;
import lotto.model.domain.BonusValidator;
import lotto.model.domain.WinningLotto;

public class BonusNumberService {
    private final BonusValidator validator = new BonusValidator();

    public Bonus getBonusNumberIfValid(WinningLotto winningLotto, String bonusNumber) {
        try {
            int bonusInteger = validator.validateBonusIsNumeric(bonusNumber);
            validator.validateNumberBetweenInRange(bonusInteger);
            validator.validateWinningNumbersContainBonusNumber(winningLotto.getNumbers(), bonusInteger);
            return new Bonus(bonusInteger);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
