package lotto;

import java.util.List;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || !isAllUnique(numbers) || !isWithinRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자 중 중복되지 않게 6개를 입력해야 합니다.");
        }
        if (duplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않게 입력해야 합니다.");
        }
    }

    public boolean duplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumber = new HashSet<>(numbers);
        return uniqueNumber.size() != numbers.size();
    }

    private boolean isAllUnique(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        return numberSet.size() == numbers.size();
    }

    private boolean isWithinRange(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> number >= 1 && number <= 45);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}

