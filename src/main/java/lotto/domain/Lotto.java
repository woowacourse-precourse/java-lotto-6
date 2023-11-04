package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }else if(hasDuplicates(numbers)){
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private Boolean hasDuplicates(List<Integer> numbers){
        Set<Integer> compareNumbers = new HashSet<>(numbers);
        return compareNumbers.size() != numbers.size();
    }
}
