package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.view.InputValidator;

public class Lotto {
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
        if (numbers.size() != 6) {
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
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public boolean contains(final Number bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private static void validate(List<Integer> list) {
        validRange(list);
        validDuplicated(list);
    }


    private static void validRange(List<Integer> list) {
        boolean overRange = list.stream().anyMatch(num -> num > 45);
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

    private static List<Integer> toIntegerList(List<String> stringList) {
        return stringList.stream()
                .map(Integer::parseInt)
                .toList();
    }

    public List<Number> getNumbers() {
        return numbers;
    }
}
