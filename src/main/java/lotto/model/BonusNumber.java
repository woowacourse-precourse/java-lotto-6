package lotto.model;


import static lotto.util.Constants.ERROR;
import static lotto.util.validators.BonusNumberValidator.validateBonusNumber;


public class BonusNumber {
    private final Integer bonusNumber;

    private BonusNumber(){
        throw new AssertionError(ERROR + "기본 생성자로 생성할 수 없습니다.");
    }
    public BonusNumber(String bonusNumber, WinningNumbers winningNumbers) {
        validateBonusNumber(bonusNumber, winningNumbers);
        this.bonusNumber = Integer.valueOf(bonusNumber);
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }
}
