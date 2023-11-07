package lotto.model.lotto;

import java.util.List;

import static lotto.model.validator.InputValidator.*;

public class BonusNumber {
    private int bonus;

    public BonusNumber(WinningNumber winningNumber, String inputBonus) {
        isInputEmpty(inputBonus);
        checkNumericInput(inputBonus);
        this.bonus = Integer.parseInt(inputBonus);
        numberMustBe1To45(List.of(bonus));
        lottoMustBeUniqueNumber(winningNumber, bonus);
    }

    public int getNumber() {
        return bonus;
    }
}
