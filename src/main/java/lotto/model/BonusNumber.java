package lotto.model;

import java.util.List;

import static lotto.model.validator.InputValidator.numberMustBe1To45;

public class BonusNumber {
    private int bonus;

    public BonusNumber(WinningNumber winningNumber, String bonus) {
        this.bonus = Integer.parseInt(bonus);
        numberMustBe1To45(List.of(this.bonus));
        // TODO: 1등 번호와 겹칠시 예외
    }

    public int getNumber() {
        return bonus;
    }
}
