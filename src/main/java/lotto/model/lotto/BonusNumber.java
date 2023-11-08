package lotto.model.lotto;

import static lotto.validator.Validator.*;

import java.util.List;

public class BonusNumber {
    private int bonus;

    public BonusNumber(WinningNumber winningNumber, String inputBonus) {
        isInputEmpty(inputBonus);
        checkNumericInput(inputBonus);
        this.bonus = Integer.parseInt(inputBonus);
        numberMustBe1To45(List.of(bonus));
        lottoMustBeUniqueNumber(winningNumber, bonus);
    }

    public int getBonusNumber() {
        return bonus;
    }
}
