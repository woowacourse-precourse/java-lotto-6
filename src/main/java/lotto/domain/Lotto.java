package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> generatedNumbers) {
        validateCount(generatedNumbers);
        validateDuplicate(generatedNumbers);
        this.numbers = sortNumbersToAsc(generatedNumbers);

        Printer printer = new Printer();
        printer.showLotteryNumbers(numbers);
    }

    public List<Integer> getLotteryNumbers() {
        return numbers;
    }

    private List<Integer> sortNumbersToAsc(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>(numbers);
        Collections.sort(result);
        return result;
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }
}

