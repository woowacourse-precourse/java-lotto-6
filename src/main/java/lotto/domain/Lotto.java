package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int startNumber = 1;
    private static final int endNumber = 45;
    private static final int lottoNumberCount = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbersRangeCheck(numbers);
        duplicateCheck(numbers);
        sortLotto(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != lottoNumberCount) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getLotto() {
        return this.numbers;
    }

    private void sortLotto(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    private void numbersRangeCheck(List<Integer> numbers) {
        for(int number : numbers)
            rangeCheck(number);
    }

    private void rangeCheck(int number) {
        if(number > endNumber || number < startNumber) throw new IllegalArgumentException();
    }

    private void duplicateCheck(List<Integer> numbers) {

        Set<Integer> noDuplicateNumbers = new HashSet<>();
        for(int number : numbers)
            noDuplicateNumbers.add(number);

        if(noDuplicateNumbers.size() != numbers.size()) throw new IllegalArgumentException();
    }
}
