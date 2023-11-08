package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || numbers.size() != numbers.stream().distinct().count()) {
            System.out.println("[ERROR] 1부터 45까지 중복되지 않은 6개의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
