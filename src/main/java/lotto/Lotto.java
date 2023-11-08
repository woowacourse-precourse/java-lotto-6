package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public static Lotto create() {
        return new Lotto();
    }

    public static Lotto create(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    //computer's Lotto constructor
    private Lotto() {
        this.numbers = LottoMaker.generate();
    }

    //user's Lotto constructor
    private Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateRange(numbers);
        validateDuplication(numbers);

        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (isValidLength(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidLength(List<Integer> numbers) {
        return numbers.size() != 6;
    }

    private void validateDuplication(List<Integer> numbers) {
        if (hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers) {
        return numbers.size() != new HashSet<Integer>(numbers).size();
    }

    private void validateRange(List<Integer> numbers) {
        if (isNotRequiredRange(numbers)) {
            throw new IllegalArgumentException("1부터 45까지의 숫자만 입력할 수 있습니다.");
        }
    }

    private boolean isNotRequiredRange(List<Integer> numbers) {
        return numbers.stream().anyMatch(number -> number < 1 || number > 45);
    }

    public List<Integer> getLottoNumbers() {
        return List.copyOf(numbers);
    }

    public boolean contain(int number) {
        return numbers.contains(number);
    }
}
