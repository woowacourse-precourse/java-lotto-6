package lotto.domain;

import static lotto.exception.ErrorType.InsideListDuplicatedException;
import static lotto.exception.ErrorType.InvalidNumberSizeException;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.LottoException;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MAX_NUM = 45;
    private static final String DELIMITER_AND_SPACE = ", ";
    private static final String LIST_PREFIX = "[";
    private static final String LIST_SUFFIX = "]";
    private static final int START_NUM = 1;
    private final List<Number> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers
                .stream()
                .map(Number::from)
                .toList();
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

    private static void validDuplicated(final List<Integer> list) {
        long uniqueCount = list.stream().distinct().count();
        if (uniqueCount < list.size()) {
            throw new LottoException(InsideListDuplicatedException);
        }
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validDuplicated(numbers);
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new LottoException(InvalidNumberSizeException);
        }
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

    public List<Number> getNumbers() {
        return numbers;
    }
}
