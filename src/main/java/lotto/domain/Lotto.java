package lotto.domain;

import lotto.util.Validator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> sortedNumbers = sortNumbers(numbers);
        validate(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.checkNumbersSize(numbers);
        Validator.checkNumbersRange(numbers);
        Validator.checkDuplicateNumber(numbers);
    }

        public boolean isContain(int target) {
            return numbers.contains(target);
        }

    public int getMatchCount(Lotto winninLotto) {
        int matchCount = 0;
        for (int number : numbers) {
            if (winninLotto.isContain(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);

        return sortedNumbers;
    }

    @Override
    public String toString() {
        return ""+numbers;
    }
}
