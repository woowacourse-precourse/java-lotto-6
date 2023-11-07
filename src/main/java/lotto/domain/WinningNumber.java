package lotto.domain;

import static lotto.util.ValidateMessage.*;

public class WinningNumber {
    private final Lotto lotto;
    private final int bonusNumber;


    public WinningNumber(Lotto lotto, String bonus) {
        int bonusNumber = validateBonusNumber(bonus);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private int validateBonusNumber(String bonusNumber) {
        if (!bonusNumber.matches(INPUT_AMOUNT_TYPE)) {
            throw new IllegalArgumentException(ERROR_NUMBER_MESSAGE);
        }
        return Integer.parseInt(bonusNumber);
    }

    public Lotto getLotto() {
        return lotto;
    }


}
