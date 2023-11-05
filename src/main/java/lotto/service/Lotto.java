package lotto.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        this.numbers = numbers;
    }

    private void duplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateLotto = new HashSet<>(numbers);
        List<Integer> numberNonDuplicate = new ArrayList<>(nonDuplicateLotto);
        if (numberNonDuplicate.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복 없이 6개여야 합니다!");
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다!");
        }
    }

}
