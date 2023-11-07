package lotto.domain;

import static lotto.util.RandomLottoNumberGenerator.LOTTO_LOWER_BOUND;
import static lotto.util.RandomLottoNumberGenerator.LOTTO_UPPER_BOUND;

import java.util.HashSet;
import java.util.List;
import lotto.util.RandomLottoNumberGenerator;

public class Lotto {
    public static final String LOTTO_NUMBER_BOUNDARY_ERROR = "로또번호는 1에서 45 사이여야 합니다.";
    private static final String LOTTO_NUMBER_DUPLICATION_ERROR = "로또 번호는 서로 중복될 수 없습니다.";
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto generateRandom() {
        return new Lotto(RandomLottoNumberGenerator.generate());
    }

    public void printItself() {
        System.out.println(numbers.stream().sorted().toList());
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int matchCount(Lotto comparingLotto) {
        int matchCount = 0;
        for (Integer number : this.numbers) {
            if (comparingLotto.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private void validate(List<Integer> numbers) {
        validateSizeOfLottoNumbers(numbers);
        validateLottoNumberBoundary(numbers);
        validateNoDuplicated(numbers);
    }

    private void validateSizeOfLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLottoNumberBoundary(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LOTTO_LOWER_BOUND || LOTTO_UPPER_BOUND < number) {
                throw new IllegalArgumentException(LOTTO_NUMBER_BOUNDARY_ERROR);
            }
        }
    }

    private void validateNoDuplicated(List<Integer> numbers) {
        int originSize = numbers.size();
        int distinctSize = new HashSet<>(numbers).size();

        if (originSize != distinctSize) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATION_ERROR);
        }
    }

}
