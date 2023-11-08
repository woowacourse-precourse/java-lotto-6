package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    public final static int PRICE = 1000;
    public final static int MIN_NUMBER = 1;
    public final static int MAX_NUMBER = 45;
    public final static int SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateRangeOfNumbers(numbers);
        validateDuplication(numbers);
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private void validateRangeOfNumbers(List<Integer> numbers) {
        numbers.forEach((number) -> {
            if (number < Lotto.MIN_NUMBER || number > Lotto.MAX_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1이상 45이하의 숫자여야 합니다.");
            }
        });
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != Lotto.SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    @Override
    public String toString() {
        List<String> lottoNumbers = this.numbers.stream()
                .map(String::valueOf)
                .toList();
        return '[' + String.join(", ", lottoNumbers) + ']';
    }
}
