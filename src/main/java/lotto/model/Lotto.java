package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int PRICE = 1000;
    public static final int LOTTO_LOWER_INCLUSIVE = 1;
    public static final int LOTTO_UPPER_INCLUSIVE = 45;
    public static final int LOTTO_SIZE = 6;
    private static final String INVALID_SIZE_ERROR = "로또 번호는 " + LOTTO_SIZE + "자리여야 합니다.";
    private static final String OUT_OF_RANGE_ERROR =
            "로또 번호는 " + LOTTO_LOWER_INCLUSIVE + "부터 " + LOTTO_UPPER_INCLUSIVE + " 사이의 숫자ㅒ야 합니다.";
    private static final String DUPLICATE_NUMBER_ERROR = "로또 번호는 중복되지 않아야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateInRange(numbers);
        validateUnique(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_SIZE_ERROR);
        }
    }

    private void validateInRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (isOutOfRange(number)) {
                throw new IllegalArgumentException(OUT_OF_RANGE_ERROR);
            }
        });
    }

    private boolean isOutOfRange(Integer number) {
        return number < LOTTO_LOWER_INCLUSIVE || number > LOTTO_UPPER_INCLUSIVE;
    }

    private void validateUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR);
        }
    }


}
