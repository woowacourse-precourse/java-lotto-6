package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수가 6이 아닙니다.");
        }
    }

    public void checkDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);
        if (numbers.size() != numSet.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 존재합니다.");
        }
    }

    public void printNumbers() {
        System.out.println(numbers.toString());
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}