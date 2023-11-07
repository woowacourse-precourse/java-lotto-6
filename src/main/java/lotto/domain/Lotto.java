package lotto.domain;


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

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
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

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
