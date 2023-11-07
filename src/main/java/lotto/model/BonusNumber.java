package lotto.model;

import java.util.List;

import static lotto.model.validator.InputValidator.lottoMustBeUniqueNumber;
import static lotto.model.validator.InputValidator.numberMustBe1To45;

public class BonusNumber {
    private int bonus;

    public BonusNumber(WinningNumber winningNumber, String inputBonus) {
        this.bonus = Integer.parseInt(inputBonus);
        numberMustBe1To45(List.of(bonus));
        lottoMustBeUniqueNumber(winningNumber, bonus);
    }

    public int getNumber() {
        return bonus;
    }
}
