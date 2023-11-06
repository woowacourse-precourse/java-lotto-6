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
    private final List<Number> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validate(numbers);
        this.numbers = numbers
                .stream()
                .map(Number::from)
                .toList();
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> randomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private static List<Integer> sortNumber(List<Integer> numbers) {
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

    private static void validate(List<Integer> list) {
        validRange(list);
        validDuplicated(list);
    }


    private static void validRange(List<Integer> list) {
        boolean overRange = list.stream().anyMatch(num -> num > LOTTO_MAX_NUM);
        if (overRange) {
            throw new IllegalArgumentException("로또 번호의 범위는 45입니다!");
        }
    }

    private static void validDuplicated(List<Integer> list) {
        long uniqueCount = list.stream().distinct().count();
        if (uniqueCount < list.size()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다!");
        }
    }

}
