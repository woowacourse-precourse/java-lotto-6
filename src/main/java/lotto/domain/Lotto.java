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
    }

    public void lottoByDuplicateNumber() {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("서로 다른 로또 번호를 입력해주세요.");
        }
    }

    public boolean contains(BounsNumber bounsNumber) {
        return numbers.contains(bounsNumber.getBounsNumber());
    }
}
