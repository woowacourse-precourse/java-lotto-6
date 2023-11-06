package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("6개의 숫자가 아닙니다.");
        }

        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numbers.size() != numberSet.size()){
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }

        for (int num: numbers){
            if (!(num >= 1 && num <= 45)){
                throw new IllegalArgumentException("1에서 45사이의 수가 아닙니다.");
            }
        }

        
    }



    // TODO: 추가 기능 구현
}
