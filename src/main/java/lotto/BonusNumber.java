package lotto;

import java.util.List;
import lotto.EnumList.ConstantErrorMessage;

public class BonusNumber {
    private static int number = 0;

    public BonusNumber(List<Integer> lottoNumber, String bonus) {
        checkNumber(bonus);
        duplicateNumber(lottoNumber, bonus);
        number = Integer.parseInt(bonus);
    }

    private void duplicateNumber(List<Integer> lottoNumber, String bonus) {
        int bonusNumber = Integer.parseInt(bonus);
        boolean isPresent = lottoNumber.stream()
                .anyMatch(number -> number == bonusNumber);

        if (isPresent) {
            throw new IllegalArgumentException(ConstantErrorMessage.ERROR_LOTTO_NUMBER_DUPLICATE.errorMessage());
        }
    }

    private void checkNumber(String bonus) {
        boolean isNumber = bonus.chars().allMatch(Character::isDigit);

        if (!isNumber) {
            throw new IllegalArgumentException(ConstantErrorMessage.ERROR_NUMBER.errorMessage());
        }
    }

    public int bonusNumber() {
        return number;
    }
}
