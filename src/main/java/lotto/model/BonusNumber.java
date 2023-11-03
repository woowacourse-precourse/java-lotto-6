package lotto.model;

import lotto.constant.ValidateMessage;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        isBetween1And45(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void isBetween1And45(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            ValidateMessage.BONUS_NUMBER_IS_BETWEEN_1_TO_45.throwException();
        }
    }

//    private void isDuplicate(List<Integer> winnerNumbers) {
//
//        if (count != winnerNumbers.size()) {
//            ValidateMessage.BONUS_NUMBER_IS_DUPLICATE.throwException();
//        }
//    }
    
    public int getBonusNumber() {
        return bonusNumber;
    }
}
