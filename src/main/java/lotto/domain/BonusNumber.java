package lotto.domain;

import lotto.validator.LottoNumberValidator;

public class BonusNumber {
    private static BonusNumber bonusNumber = null;
    private static int number;

    private BonusNumber(int number) {
        validator(number);
        this.number = number;
    }

    public static BonusNumber create(int number) {
        if(bonusNumber == null){
            bonusNumber = new BonusNumber(number);
        }
        return bonusNumber;
    }

    public static int getNumber() {
        return number;
    }

    private void validator(int number) {
        LottoNumberValidator.validateDuplication(number,WinningNumber.getWinningNumbers());
    }

}
