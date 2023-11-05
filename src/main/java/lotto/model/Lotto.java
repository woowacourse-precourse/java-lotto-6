package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.Message;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        // 1. 숫자 개수 검증
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Message.EXCPTION_NOT_A_SIX);
        }
        
        // 2. 숫자 중복 여부 검증
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(Message.EXCPTION_DUPLICATED);
        }
    }
}
