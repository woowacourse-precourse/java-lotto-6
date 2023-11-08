package lotto.domain;

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
        int[] arr = new int[46];
        for (Integer x: numbers) {
            arr[x]++;
            if (arr[x] == 2) {
                throw new IllegalArgumentException();
            }
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getnumbers() {
        return this.numbers;
    }
}
