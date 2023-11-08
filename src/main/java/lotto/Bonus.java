package lotto;

import static lotto.ExceptionHandler.checkBonusNumber;

public class Bonus {

    private final Integer number;
    private final Lotto lotto;


    public Bonus(Integer number, Lotto lotto) {

        validate(number, lotto);
        this.number = number;
        this.lotto = lotto;
    }

    private void validate(Integer number, Lotto lotto) {
        checkBonusNumber(number, lotto.getNumbers());
    }

    public Integer getBonusNumber() {
        return number;
    }
}
