package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkList(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private void checkList(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);
        if(numSet.size()!= numbers.size()){
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    // TODO: 추가 기능 구현
    public boolean contains(int num) {
        return this.numbers.contains(num);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int get(int index) {
        return numbers.get(index);
    }

}
