package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final String ERROR_MESSAGE = "[ERROR]";

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 번호는 중복될 수 없습니다");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean containBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}