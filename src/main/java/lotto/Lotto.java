package lotto;

import static lotto.util.ConstantNumbers.LOTTO_SECOND_QUANTITY;
import static lotto.util.ConstantNumbers.RESET_INTEGER_TWO;
import static lotto.util.Validator.validateAlreadyHasNumber;
import static lotto.util.Validator.validateDuplicateNumber;
import static lotto.util.Validator.validateListNumberMinimumOrMaximum;
import static lotto.util.Validator.validateSizeMiss;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSizeMiss(numbers);
        validateListNumberMinimumOrMaximum(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    /*private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }*/

    public void checkDuplicateBonusNumber (Integer bonusNumber) {
        validateAlreadyHasNumber(this.numbers, bonusNumber);
    }

    public Integer countSameNumber(Lotto number, Integer bonusNumber) {
        Integer countNumber = (int) number.numbers.stream()
                .filter(this.numbers::contains).count();

        if (countNumber.equals(LOTTO_SECOND_QUANTITY.getConstant())) {
            countNumber = hasBonusNumber(bonusNumber, countNumber);
        }

        return countNumber - RESET_INTEGER_TWO.getConstant();
    }

    private Integer hasBonusNumber (Integer bonusNumber, Integer key) {
        if (this.numbers.contains(bonusNumber)) {
            return key + 1;
        }

        return key;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
