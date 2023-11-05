package lotto.domain;

import java.util.List;
import lotto.exception.InvalidInput;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void validateBonusNumber(int bonusNumber) {
        InvalidInput invalidInput = new InvalidInput();
        invalidInput.duplicateNumberException(numbers, bonusNumber);
    }

    public int getScore(int bonusNumber, List<Integer> myLottoNumber) {
        int score = getSameNumberCount(myLottoNumber);

        if (hasBonusNumber(bonusNumber, myLottoNumber) && score == 5 || score == 6) {
            score++;
        }

        return score;
    }

    private void validate(List<Integer> numbers) {
        InvalidInput invalidInput = new InvalidInput();

        invalidInput.sizeExceededException(numbers);
        invalidInput.duplicateNumberException(numbers);
        invalidInput.outOfRangeException(numbers);
    }

    private int getSameNumberCount(List<Integer> myLottoNumber) {
        long sameNumberCount = myLottoNumber.stream()
                .filter(numbers::contains)
                .count();

        return (int)sameNumberCount;
    }

    private Boolean hasBonusNumber(int bonusNumber, List<Integer> myLottoNumber) {
        if (myLottoNumber.contains(bonusNumber)) {//보너스 볼 일치
            return true;
        }

        return false;
    }

}
