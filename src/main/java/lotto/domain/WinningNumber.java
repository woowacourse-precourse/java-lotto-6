package lotto.domain;


import java.util.List;

import static lotto.util.Const.MAX_NUMBER;
import static lotto.util.Const.MIN_NUMBER;
import static lotto.util.ValidateMessage.*;

public class WinningNumber {
    private static Lotto lotto;

    private final int bonusNumber;


    public WinningNumber(Lotto lotto, String bonus) {
        int bonusNumber = validateBonusNumber(bonus);
        this.lotto = lotto;
        validateBonus(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonus(int bonusNumber) {
        validateBonusBetweenNumber(bonusNumber);
        validateBonusUnique(bonusNumber);

    }

    private static void validateBonusBetweenNumber(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_MESSAGE);
        }
    }

    private static void validateBonusUnique(int bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumber();
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_UNIQUE_MESSAGE);
        }
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

    public int getBonusNumber() {
        return bonusNumber;
    }


}
