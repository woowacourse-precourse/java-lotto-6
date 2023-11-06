package lotto.domain;

import static lotto.validator.Validator.validateBonusNumber;
import static lotto.validator.Validator.validateMainNumbers;

import java.util.List;

public class WinningNumbers {
    private List<Integer> mainNumbers;
    private int bonusNumber;

    public WinningNumbers() {
    }

    public WinningNumbers(List<Integer> mainNumbers, int bonusNumber) {
        validateMainNumbers(mainNumbers);
        validateBonusNumber(mainNumbers, bonusNumber);
        this.mainNumbers = mainNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void setMainNumbers(List<Integer> mainNumbers) {
        validateMainNumbers(mainNumbers);
        this.mainNumbers = mainNumbers;
    }

    public void setBonusNumber(int bonusNumber) {
        validateBonusNumber(this.mainNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public boolean isMainNumber(int number) {
        return this.mainNumbers.contains(number);
    }

    public boolean isBonusNumber(int number) {
        return bonusNumber == number;
    }

}
