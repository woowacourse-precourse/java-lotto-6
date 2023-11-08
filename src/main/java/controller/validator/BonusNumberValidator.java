package controller.validator;

import util.ConstantOfLotto;
import util.ErrorMessage;

public class BonusNumberValidator {

    public int checkBonusNumberValidation(String input) {
        int bonusNumber = checkBonusNumberContainCharacter(input);
        checkBonusNumberRange(bonusNumber);
        return bonusNumber;
    }

    private void checkBonusNumberRange(int number) {
        if(number < ConstantOfLotto.MINIMUM_OF_LOTTO_NUMBER) {
            System.out.println(ErrorMessage.OUT_OF_LOTTO_NUMBER_RANGE.getErrorMessage());
            throw new IllegalArgumentException();
        }
        if(number > ConstantOfLotto.MAXIMUM_OF_LOTTO_NUMBER) {
            System.out.println(ErrorMessage.OUT_OF_LOTTO_NUMBER_RANGE.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    private int checkBonusNumberContainCharacter(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.LOTTO_MUST_BE_COMPOSED_OF_NUMBER.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }
}
