package lotto.domain;

import static lotto.message.LottoErrorMessage.INVALID_DUPLICATE;
import static lotto.message.LottoErrorMessage.INVALID_SIZE;

import java.util.HashSet;
import java.util.List;
public class Lotto {

    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final String LOTTO_NUMBER_FORMAT = "숫자";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int compareNumbers(List<Integer> winningNumbers) {
        return (int) numbers.stream().flatMap(
                number -> winningNumbers
                        .stream()
                        .filter(number::equals)
        ).count();
    }

    public boolean compareNumber(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_SIZE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        int numbersCount = new HashSet<>(numbers).size();
        if (numbersCount != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_DUPLICATE);
        }
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
