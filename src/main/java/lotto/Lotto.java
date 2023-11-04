package lotto;

import static lotto.message.LottoGameErrorMessage.NUMBERS_ARE_DUPLICATED;
import static lotto.message.LottoGameErrorMessage.NUMBERS_NOT_IN_RANGE;
import static lotto.message.LottoGameErrorMessage.SIZE_IS_NOT_EXACT;

import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.util.VisibleForTesting;

public class Lotto {
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;
    public static final int LOTTO_NUMBER_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateList(numbers);
        this.numbers = numbers;
    }

    public String getLottoNumbersAsFormat() {
        return "[" + numbers.stream().map(String::valueOf).collect(Collectors.joining(", ")) + "]";
    }

    private void validateList(List<Integer> numbers) {
        if (!isListSizeExact(numbers)) {
            throw new IllegalArgumentException(SIZE_IS_NOT_EXACT.getMessage());
        }
        if (!isNumbersUnique(numbers)) {
            throw new IllegalArgumentException(NUMBERS_ARE_DUPLICATED.getMessage());
        }
        if (!isNumbersInRange(numbers)) {
            throw new IllegalArgumentException(NUMBERS_NOT_IN_RANGE.getMessage());
        }
    }

    @VisibleForTesting
    protected static boolean isListSizeExact(List<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBER_SIZE;
    }

    @VisibleForTesting
    protected static boolean isNumbersUnique(List<Integer> numbers) {
        return numbers.size() == numbers.stream().distinct().count();
    }

    @VisibleForTesting
    protected static boolean isNumbersInRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number -> LOTTO_START_NUMBER <= number && number <= LOTTO_END_NUMBER);
    }
}
