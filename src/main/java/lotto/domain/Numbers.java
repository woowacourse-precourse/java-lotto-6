package lotto.domain;

import lotto.type.ErrorCode;

import java.util.List;

public class Numbers {

    private List<Integer> luckyNumbers;
    private int bonusNumber;

    public List<Integer> getLuckyNumbers() {
        return luckyNumbers;
    }
    public void setLuckyNumbers(List<Integer> numbers) {
        this.luckyNumbers = numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
    public void setBonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (getLuckyNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorCode.INVALID_BONUS_NUMBER.getDescription());
        }
    }

}
