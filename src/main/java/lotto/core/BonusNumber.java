package lotto.core;

import lotto.common.MultiplePureNumbers;
import lotto.common.PureNumber;

public class BonusNumber {

    private static final int MIN_INCLUDE = 1;
    private static final int MAX_INCLUDE = 45;
    private int bonusNumber;

    public static BonusNumber create(LotteryTicket winningLotteryTicket, PureNumber number)
            throws IllegalArgumentException {
        return new BonusNumber(winningLotteryTicket, number.getNumber());
    }

    public BonusNumber(LotteryTicket winningLotteryTicket, int bonusNumber) throws IllegalArgumentException {
        validate(winningLotteryTicket, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    private void validate(LotteryTicket winningLotteryTicket, int bonusNumber) throws IllegalArgumentException {
        validateDuplicate(winningLotteryTicket, bonusNumber);
        validateRange(bonusNumber);
    }

    private void validateDuplicate(LotteryTicket winningLotteryTicket, int bonusNumber) throws IllegalArgumentException {
        if (winningLotteryTicket.containsGivenNumber(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < MIN_INCLUDE || bonusNumber > MAX_INCLUDE) {
            throw new IllegalArgumentException();
        }
    }
}
