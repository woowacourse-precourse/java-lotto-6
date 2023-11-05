package lotto.domain;

import static lotto.constant.ErrorMessage.OUT_OF_NUMBER_RANGE;


public class BonusNumber {

    private final int bonusNumber;
    RandomNumber randomNumber = new RandomNumber();


    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
      //  validateDuplicateLotto(bonusNumber, randomNumber.getNumbers());
        validateOutOfRange(bonusNumber);
    }

    //private void validateDuplicateLotto(int bonusNumber, List<Integer> numbers) {
     //   if (numbers.contains(bonusNumber)) {
       //     throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE.getMessage());
       // }

    //}

    private void validateOutOfRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(OUT_OF_NUMBER_RANGE.getMessage());
        }
    }

    public int getNumber() {
        return bonusNumber;
    }
}