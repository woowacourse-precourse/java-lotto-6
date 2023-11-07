package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;

    private static final String INVALID_SIZE_MESSAGE = "[ERROR] 로또 번호는 %d개여야 합니다.";
    private static final String DUPLICATE_NUMBER_MESSAGE = "[ERROR] 로또 번호는 중복될 수 없습니다 .";
    private static final String NUMBER_OUT_OF_RANGE_MESSAGE = "[ERROR] 로또 번호는 %d부터 %d까지어야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSizeExact(numbers);
        validateNoDuplicate(numbers);
        validateNumbersInRange(numbers);
        
        numbers.sort(Comparator.naturalOrder());
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        numbers = new ArrayList<>(numbers);
        return new Lotto(numbers);
    }

    private void validateSizeExact(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(String.format(INVALID_SIZE_MESSAGE, LOTTO_COUNT));
        }
    }

    private void validateNoDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_COUNT) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < START_LOTTO_NUMBER || number > END_LOTTO_NUMBER) {
                throw new IllegalArgumentException(
                        String.format(NUMBER_OUT_OF_RANGE_MESSAGE, START_LOTTO_NUMBER, END_LOTTO_NUMBER));
            }
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
