package lotto.entity;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        checkDuplicate(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void printList(){
        System.out.println(this.numbers.stream().sorted().toList());
    }

    public void checkDuplicate(List<Integer> numbers){
        if (new HashSet<>(numbers).size() != 6) throw new IllegalArgumentException();
    }

    // TODO: 추가 기능 구현
}
