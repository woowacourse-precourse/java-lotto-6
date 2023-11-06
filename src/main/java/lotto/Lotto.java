package lotto;

import java.util.ArrayList;
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
        List<Integer> copyNums = new ArrayList<>();

        if(!numbers.stream().allMatch(num-> !copyNums.contains(num) && copyNums.add(num))){
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
