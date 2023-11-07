package lotto;

import java.util.*;

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
        Set<Integer> uniqueNumber = new HashSet<>(numbers);
        if(uniqueNumber.size() != numbers.size()){
            throw new IllegalArgumentException("중복된 로또번호가 있습니다.");
        }
    }

    // TODO: 추가 기능 구현
}
