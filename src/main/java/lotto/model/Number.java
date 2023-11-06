package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.view.ErrorMessage.duplicatedBonusNumber;

public class Number {
    private static final int start = 1;
    private static final int end = 45;
    private static final int size = 6;

    private void checkNumberLength(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != size) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            checkRange(number);
        }
    }

    protected void checkRange(int num) throws IllegalArgumentException {
        if ((num < start) || (num > end)) {
            throw new IllegalArgumentException();
        }
    }


    public void checkDuplicate(List<Integer> numbers, BonusNumber bonus) throws IllegalArgumentException{
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.contains(bonus.getBonusNumber())) {
            duplicatedBonusNumber();
            throw new IllegalArgumentException();
        }
    }

}
