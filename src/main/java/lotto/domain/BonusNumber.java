package lotto.domain;

import lotto.utils.Message;

public class BonusNumber {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private int bonusNumber;

    public BonusNumber(String bonusNumber, WinningNumber winningNumber) {
        this.bonusNumber = validate(validateIsIntPrice(bonusNumber), winningNumber);
    }

    private int validate(int bonusNumber, WinningNumber winningNumber) {
        if (bonusNumber < LOTTO_MIN_NUMBER || LOTTO_MAX_NUMBER < bonusNumber) {
            throw new IllegalArgumentException(Message.NUMBER_RANGE_ERROR.getMessage());
        } else if (winningNumber.getLotto().getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(Message.DUPLICATION_BONUS_ERROR.getMessage());
        }
        return bonusNumber;
    }

    private int validateIsIntPrice(String bonus) {
        int bonusNumber = 0;
        try {
            bonusNumber = Integer.parseInt(bonus);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.INPUT_INTERGER_ERROR.getMessage());
        }
        return bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
