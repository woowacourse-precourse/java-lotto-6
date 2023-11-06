package lotto.model;

import lotto.utils.LottoGenerator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        this(LottoGenerator.generateLottoNumbers());
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private List<Integer> getAscendingNumbers() {
        return numbers.stream().sorted().toList();
    }

    @Override
    public String toString() {
        return String.join(", ", getAscendingNumbers().toString());
    }
}
