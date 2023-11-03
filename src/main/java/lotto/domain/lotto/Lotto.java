package lotto.domain.lotto;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto {

    private static final String INVALID_LOTTO_LENGTH = "[ERROR] 로또 번호의 길이는 6개여야 합니다.";
    private static final String DUPLICATES_LOTTO_NUMBERS = "[ERROR] 로또 번호는 중복을 허용하지 않습니다.";

    private static final int LOTTO_LENGTH = 6;

    private final List<Integer> numbers;

    private Lotto(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(final List<Integer> numbers) {
        validate(numbers);
        numbers.sort(Comparator.naturalOrder());
        return new Lotto(numbers);
    }

    private static void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicates(numbers);

    }

    private static void validateLength(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(INVALID_LOTTO_LENGTH);
        }
    }

    private static void validateDuplicates(final List<Integer> numbers) {
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException(DUPLICATES_LOTTO_NUMBERS);
        }
    }

    private static boolean isDuplicate(final List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .toList()
                .size() != numbers.size();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
