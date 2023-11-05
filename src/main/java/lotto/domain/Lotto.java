package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    // Fields, Constructor
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }


    // Features
    public String toString() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        String string = sortedNumbers.toString();
        return string;
    }

    public int getPoint(List<Integer> winningNumber) {
        int point = compareWithWinningNumber(winningNumber);

        return point;
    }


    // Internal Implements
    // 당첨, 보너스 번호와 비교하여 점수를 반환한다.
    private int compareWithWinningNumber(List<Integer> winningNumber) {
        int point = 0;
        for (int i = 0; i < winningNumber.size(); i++) {
            int target = winningNumber.get(i);
            if (numbers.contains(target)) {
                point++;
            }
            if (i < 6 && point == 6) {
                point++;
            }
        }
        return point;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        validateDuplicated(numbers);
    }

    private void validateDuplicated(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if (!set.add(number)) {
                throw new IllegalArgumentException();
            }
        }
    }

}
