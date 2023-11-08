package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final String INVALID_LOTTO_NUMBER_RANGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String INVALID_LOTTO_NUMBER_SIZE = "로또 번호는 개수는 6개여야 합니다.";
    private static final String INVALID_LOTTO_NUMBER_DUPLICATE = "로또 번호는 중복될 수 없습니다.";
    private static final int VALID_LOTTO_START_NUMBER = 1;
    private static final int VALID_LOTTO_END_NUMBER = 45;
    private static final int VALID_LOTTO_NUMBERS_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    // TODO: 추가 기능 구현
    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static void validateLottoNumbers(List<Integer> lottoNumbers) {
        validateNumberSize(lottoNumbers);
        validateNumberDuplicate(lottoNumbers);
        lottoNumbers.forEach(Lotto::validateNumberRange);
    }

    private static void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != VALID_LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_SIZE);
        }
    }

    private static void validateNumberDuplicate(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        int sizeOfNumbers = numbers.size();
        int sieOfDistinctNumbers = distinctNumbers.size();

        if (sizeOfNumbers != sieOfDistinctNumbers) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_DUPLICATE);
        }
    }

    private static void validateNumberRange(int number) {
        if (number < VALID_LOTTO_START_NUMBER || number > VALID_LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE);
        }
    }
}
