package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicate(List<Integer> numbers){
        HashSet<Integer> duplicatenum = new HashSet<>(numbers);
        if (duplicatenum.size() != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 중복되는 값이 있습니다.");
        }
    }

    private void include(List<Integer> numbers){
        if (numbers.contains(0)){
            throw new IllegalArgumentException("[ERROR] 0이 포함되어 있습니다.");
        }
    }

    private void exceeding(List<Integer> numbers){
        for (int n : numbers){
            if (n > 45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자입니다.");
            }
        }
    }
}