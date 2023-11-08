package lotto.service;

import static lotto.constant.ErrorMessage.WINNUMBER_LENGTH;
import static lotto.constant.ErrorMessage.WINNUMBER_NO_DUPLICATE_LENGTH;
import static lotto.constant.ErrorMessage.WINNUMBER_RANGE;
import static lotto.constant.NumberConstant.LAST_LOTTO_NUMBER;
import static lotto.constant.NumberConstant.NUMBERS_LENGTH;
import static lotto.constant.NumberConstant.START_LOTTO_NUMBER;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        rangeCheck(numbers);
        lengthCheck(numbers);
        duplicateCheck(numbers);
        this.numbers = numbers;
    }

    private void rangeCheck(List<Integer> numbers) {
        for (Integer winnerNumber : numbers) {
            if (isNumberNotInRange(winnerNumber)) {
                throw new IllegalArgumentException(WINNUMBER_RANGE.getMessage());
            }
        }
    }

    private boolean isNumberNotInRange(Integer winnerNumber) {
        return winnerNumber < START_LOTTO_NUMBER.getNumber()
            || winnerNumber > LAST_LOTTO_NUMBER.getNumber();
    }

    private void duplicateCheck(List<Integer> numbers) {
        Set<Integer> nonDuplicateLotto = new HashSet<>(numbers);
        List<Integer> numberNonDuplicate = new ArrayList<>(nonDuplicateLotto);
        if (isNotRightLength(numberNonDuplicate)) {
            throw new IllegalArgumentException(WINNUMBER_NO_DUPLICATE_LENGTH.getMessage());
        }

    }

    private void lengthCheck(List<Integer> numbers) {
        if (isNotRightLength(numbers)) {
            throw new IllegalArgumentException(WINNUMBER_LENGTH.getMessage());
        }
    }

    private boolean isNotRightLength(List<Integer> numbers) {
        return numbers.size() != NUMBERS_LENGTH.getNumber();
    }


}
