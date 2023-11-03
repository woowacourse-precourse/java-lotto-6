package lotto.model;

import lotto.message.ExceptionMessage;

import java.util.List;

public class BonusNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private final int bonusNumber;

    public BonusNumber(String bonusNumber, List<Integer> winningLotto) {
        validate(bonusNumber, winningLotto);
        this.bonusNumber = convertStringToInt(bonusNumber);
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
            ExceptionMessage.IS_NOT_IN_RANGE.throwException(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
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
