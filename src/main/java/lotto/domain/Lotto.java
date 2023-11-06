package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;



    public Lotto(List<Integer> numbers) {
        List<Integer> safeNumbers = validate(numbers);
        this.numbers = safeNumbers;
    }

    private List<Integer> validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        return numbers;
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }


}
