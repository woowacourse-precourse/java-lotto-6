package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> generatedNumbers) {
        validate(generatedNumbers);
        validateDuplicate(generatedNumbers);
        this.numbers = sortNumbersToAsc(generatedNumbers);

        Printer printer = new Printer();
        printer.showLotteryNumbers(numbers);
    }

    public List<Integer> getLotteryNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        // 숫자가 6개인지 확인
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> sortNumbersToAsc(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>(numbers);
        Collections.sort(result);
        return result;
    }
}

