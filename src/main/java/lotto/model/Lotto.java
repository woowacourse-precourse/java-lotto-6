package lotto.model;

import java.util.List;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {

    public static final int LOTTO_PRICE = 1_000;

    private static final String INVALID_COUNT = "로또 번호는 6개를 입력해야 합니다.";
    private static final String NUMBER_OUT_OF_RANGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String DUPLICATED_NUMBER = "로또 번호는 중복될 수 없습니다.";

    private static final int NUMBERS_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto createRandomNumberLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    private void validate(final List<Integer> numbers) {
        validateCount(numbers);
        validateInRange(numbers);
        validateNotDuplicated(numbers);
    }

    protected void validateCount(final List<Integer> numbers) {
        if (numbers.size() != NUMBERS_COUNT) {
            throw new IllegalArgumentException(INVALID_COUNT);
        }
    }

    protected void validateInRange(final List<Integer> numbers) {
        boolean outOfRange = numbers.stream().anyMatch(this::isOutOfRange);
        if (outOfRange) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE);
        }
    }

    protected void validateNotDuplicated(final List<Integer> numbers) {
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER);
        }
    }

    protected boolean isOutOfRange(final int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

    protected boolean hasDuplicates(final List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    public boolean contains(final int number) {
        return numbers.contains(number);
    }

    public Stream<Integer> stream() {
        return numbers.stream();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
