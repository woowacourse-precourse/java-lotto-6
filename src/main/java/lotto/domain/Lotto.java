package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MAX_NUM = 45;
    private static final String DELIMITER_AND_SPACE = ", ";
    private static final String LIST_PREFIX = "[";
    private static final String LIST_SUFFIX = "]";
    private static final int START_NUM = 1;
    private static final String ERROR_HEAD = "[ERROR] ";
    private final List<Number> numbers;

    public Lotto(final List<Integer> numbers) {
        validateSize(numbers);
        validate(numbers);
        this.numbers = numbers
                .stream()
                .map(Number::from)
                .toList();
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_HEAD + "로또 숫자는 6개입니다!");
        }
    }

    private static List<Integer> randomNumber() {
        return Randoms.pickUniqueNumbersInRange(START_NUM, LOTTO_MAX_NUM, LOTTO_SIZE);
    }

    private static List<Integer> sortNumber(final List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    public static Lotto createRandomLotto() {
        List<Integer> intLottos = randomNumber();
        List<Integer> sortLottos = sortNumber(intLottos);
        return new Lotto(sortLottos);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(Number::toString)
                .collect(Collectors.joining(DELIMITER_AND_SPACE, LIST_PREFIX, LIST_SUFFIX));
    }

    public boolean contains(final Number bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private static void validate(final List<Integer> list) {
        validRange(list);
        validDuplicated(list);
    }


    private static void validRange(final List<Integer> list) {
        boolean overRange = list.stream().anyMatch(num -> num > LOTTO_MAX_NUM);
        if (overRange) {
            throw new IllegalArgumentException(ERROR_HEAD + "로또 번호의 범위는 45입니다!");
        }
    }

    private static void validDuplicated(final List<Integer> list) {
        long uniqueCount = list.stream().distinct().count();
        if (uniqueCount < list.size()) {
            throw new IllegalArgumentException(ERROR_HEAD + "중복된 숫자가 있습니다!");
        }
    }

    public List<Number> getNumbers() {
        return numbers;
    }
}
