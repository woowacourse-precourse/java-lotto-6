package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 주어진 숫자가 6개가 아닙니다.");
        }
    }

    private void duplicate(List<Integer> numbers){
        if(new HashSet<>(numbers).size() != 6){
            throw new IllegalStateException("[ERROR] 중복된 수가 있습니다.");
        }
    }
}
