package lotto.domain;

import java.util.List;

public class BonusNumberValidator {
    public int bonusNumber;
    private List<Integer> prizeNumbers;

    public BonusNumberValidator(List<Integer> prizeNumbers) {
        this.prizeNumbers = prizeNumbers;
    }

    public void validate(String number) {
        isNumber(number);
        isCorrectNumber();
        isDuplicated();
    }

    private void isNumber(String number) {
        try {
            this.bonusNumber = Integer.parseInt(number);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("숫자여야 합니다.");
        }
    }

    private void isCorrectNumber() {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("1과 45 사이의 숫자여야합니다.");
        }
    }

    private void isDuplicated() {
        if (prizeNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("중복된 숫자는 입력이 불가능합니다.");
        }
    }
}
