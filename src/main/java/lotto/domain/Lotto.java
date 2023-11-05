package lotto.domain;

import static lotto.util.RandomLottoNumberGenerator.LOTTO_LOWER_BOUND;
import static lotto.util.RandomLottoNumberGenerator.LOTTO_UPPER_BOUND;

import java.util.Collections;
import java.util.List;
import lotto.util.RandomLottoNumberGenerator;

public class Lotto {
    public static final String LOTTO_NUMBER_BOUNDARY_ERROR = "로또번호는 1에서 45 사이여야 합니다";
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public static Lotto generateRandom() {
        return new Lotto(RandomLottoNumberGenerator.generate());
    }

    public void printItself() {
        System.out.println(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSizeOfLottoNumbers(numbers);
        validateLottoNumberBoundary(numbers);
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

}
