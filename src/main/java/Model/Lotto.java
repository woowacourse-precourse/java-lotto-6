package Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        sizeValidate(numbers);
        this.numbers = numbers;
    }

    private void sizeValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    private void duplicatedNumberValidate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        if(numbers.stream().anyMatch(element -> !set.add(element))) {
            throw new IllegalArgumentException();
        }
    }

    private void sortNumbers(List<Integer> numbers) {
        numbers.stream().sorted();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
