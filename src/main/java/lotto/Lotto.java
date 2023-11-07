package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        lengthValidate(numbers);
        numberValidate(numbers);
        this.numbers = numbers;
    }

    private void lengthValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    private void numberValidate(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if(uniqueNumbers.size()!=6) throw new IllegalArgumentException();
    }
}
