package lotto.model;

import lotto.constant.Constants;
import lotto.message.ExceptionMessage;

import java.util.List;

public class BonusNumber {
    private static final int MIN_LOTTO_NUMBER = Constants.MIN_LOTTO_NUMBER.getValue();
    private static final int MAX_LOTTO_NUMBER = Constants.MAX_LOTTO_NUMBER.getValue();
    private final int bonusNumber;

    public BonusNumber(String bonusNumber, List<Integer> winningLotto) {
        validate(bonusNumber, winningLotto);
        this.bonusNumber = convertStringToInt(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(String bonusNumber, List<Integer> winningLotto) {
        isNumber(bonusNumber);
        isInRange(convertStringToInt(bonusNumber));
        isNotDuplicated(convertStringToInt(bonusNumber), winningLotto);
    }

    private void isNumber(String bonusNumber) {
        try{
            Integer.parseInt(bonusNumber);
        }
        catch (NumberFormatException ex){
            ExceptionMessage.INPUT_NOT_NUMBER_MESSAGE.throwException(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
        }
    }

    private void isInRange(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            ExceptionMessage.IS_NOT_IN_RANGE.throwException(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
        }
    }

    private void isNotDuplicated(int bonusNumber, List<Integer> winningLotto) {
        if (winningLotto.contains(bonusNumber)) {
            ExceptionMessage.INPUT_DUPLICATE_WITH_WINNING_LOTTO.throwException();
        }
    }

    private int convertStringToInt(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }
}
