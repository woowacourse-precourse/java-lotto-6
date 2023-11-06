package lotto.model;

import java.util.HashMap;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
        isInRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicate(List<Integer> numbers){
        HashMap<Integer, Integer> numberOfEach = new HashMap<>();
        for (int num : numbers){
            int repeats = numberOfEach.getOrDefault(num, 0);
            if (repeats >= 1){
                throw new IllegalArgumentException("중복되는 숫자는 입력할 수 없습니다.");
            }
            numberOfEach.put(num, repeats + 1);
        }
    }


    private void isInRange(List<Integer> numbers){
        numbers.forEach(num ->{
            if (num > 45 || num < 1){
                throw new IllegalArgumentException("숫자는 1과 45사이의 수여야 합니다.");
            }
        });
    }
}
