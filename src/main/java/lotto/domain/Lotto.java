package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Number> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
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

    public static Lotto from(String userInput) {
        // TODO 검증 후 바꿔야함
        List<String> userInputList = toStringList(userInput);
        validate(userInputList);

        // TODO 숫자로 바꿔야함.
        return new Lotto(null);
    }

    private static void validate(List<String> list) {
        validDigit(list);
        List<Integer> integerList = toIntegerList(list);
        validRange(integerList);
    }

    private static List<String> toStringList(String userInput) {
        return Arrays.stream(userInput.split(","))
                .map(String::trim)
                .toList();
    }

    private static void validDigit(List<String> list) {
        boolean isDigit = list.stream().allMatch(s -> s.matches("\\d+"));
        if (!isDigit) {
            throw new IllegalArgumentException("로또 번호는 1~45 숫자만 입력 가능합니다.");
        }
    }

    private static List<Integer> toIntegerList(List<String> stringList) {
        return stringList.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private static void validRange(List<Integer> list) {
        boolean overRange = list.stream().anyMatch(num -> num > 45);
        if (overRange) {
            throw new IllegalArgumentException("로또 번호의 범위는 45입니다!");
        }
    }

}
