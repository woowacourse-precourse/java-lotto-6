package lotto.domain;

import static lotto.constants.ExceptionMessage.LOTTO_DUPPLICATE_NUMBER;
import static lotto.constants.ExceptionMessage.LOTTO_LENGTH_OUT_RANGE;
import static lotto.constants.ExceptionMessage.LOTTO_OUT_RANGE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constants.LottoConstants;

public class Lotto {

    private final List<Integer> numbers;

    private Lotto(final List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public static Lotto from(final List<Integer> numbers) {
        validate(numbers);
        return new Lotto(numbers);
    }

    private static void validate(final List<Integer> numbers) {
        if (isSameLength(numbers)) {
            throw new IllegalArgumentException(
                    String.format(LOTTO_LENGTH_OUT_RANGE, numbers.size()));
        }
        if (!isDupplicated(numbers)) {
            throw new IllegalArgumentException(LOTTO_DUPPLICATE_NUMBER);
        }
        if (!isBoundary(numbers)) {
            throw new IllegalArgumentException(
                    String.format(LOTTO_OUT_RANGE, LottoConstants.MIN_NUMBER.getConstants(),
                            LottoConstants.MAX_NUMBER.getConstants()));
        }
    }

    private static boolean isBoundary(final List<Integer> numbers) {
        return numbers.stream().allMatch(number -> isRangeNumber(number));
    }

    private static boolean isRangeNumber(final int number) {
        return LottoConstants.MIN_NUMBER.getConstants() <= number && number <= LottoConstants.MAX_NUMBER.getConstants();

    }

    private static boolean isDupplicated(final List<Integer> numbers) {
        List<Integer> duplicated = numbers.stream().distinct().toList();
        return duplicated.size() == numbers.size();
    }

    private static boolean isSameLength(final List<Integer> numbers) {
        return numbers.size() != LottoConstants.LENGTH.getConstants();
    }

    public static Lotto createAutoLottoNumbers(final Generator generator) {
        return new Lotto(generator.generate());
    }

    public static int matchCount(final Lotto given, final List<Integer> winnings) {
        return (int) given.getLotto().stream().filter(n -> isInWinning(n, winnings)).count();
    }

    private static boolean isInWinning(final int number, final List<Integer> winnings) {
        return winnings.stream().anyMatch(n -> n == number);
    }

    public List<Integer> getLotto() {
        return Collections.unmodifiableList(numbers);
    }

}
