package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplication(List<Integer> numbers) {
        List<Integer> copy = copyNumbers(numbers);
        if(compareNumbers(numbers, copy)) {
            throw new IllegalArgumentException();
        }
    }
    private List<Integer> copyNumbers(List<Integer> numbers) {
        List<Integer> copy = new ArrayList<>();
        for(Integer num : numbers) {
            copy.add(num);
        }
        return copy;
    }
    private Boolean compareNumbers(List<Integer> numbers, List<Integer> copy) {
        for(int i=0; i<numbers.size(); i++) {
            if(compareNumber(numbers, copy, i)) {
                return true;
            }
        }
        return false;
    }
    private Boolean compareNumber(List<Integer> numbers, List<Integer> copy, int i) {
        for(int j=0; j<copy.size(); j++) {
            if(i!=j && numbers.get(i) == copy.get(j)) {
                return true;
            }
        }
        return false;
    }
    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
