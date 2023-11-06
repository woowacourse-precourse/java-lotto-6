package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.view.ErrorMessage.duplicatedBonusNumber;
import static lotto.view.ErrorMessage.outOfBoundExceptionMessage;

public class Number {
    private static final int start = 1;
    private static final int end = 45;


    protected void checkRange(int num) throws IllegalArgumentException {
        if ((num < start) || (num > end)) {
            outOfBoundExceptionMessage();
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
