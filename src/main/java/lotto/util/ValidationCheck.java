package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidationCheck {

    public void checkNumLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Message.EXCPTION_NOT_A_SIX);
        }
    }

    public void checkDuplicatedNum(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(Message.EXCPTION_DUPLICATED);
        }
    }

    public void checkNumRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException(Message.EXCPTION_DUPLICATED);
        }
    }
}