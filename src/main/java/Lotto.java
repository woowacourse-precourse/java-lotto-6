import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Collections.sort;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        hasDuplicateNumbers(numbers);
        this.numbers = sortedLotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void hasDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if(numberSet.size()!=6)throw new IllegalArgumentException();
    }

    private List<Integer> sortedLotto(List<Integer> numbers){
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
    // TODO: 추가 기능 구현
}
