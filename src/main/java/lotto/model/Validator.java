package lotto.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Validator {
    public static final String regexSixNumber = "^[0-9,]*";
    public static final String regexNumber = "^[0-9]*";

    public List<Integer> validatePickSixNumber(String rawInput) throws IllegalArgumentException {
        validateNumberList(rawInput);
        Stream<String> numberStream = Arrays.stream(rawInput.split(","));
        Stream<Integer> intStream = numberStream.map(Integer::parseInt);
        List<Integer> numbers = intStream.collect(Collectors.toList());
        validateDuplicateSix(numbers);
        validateCount(numbers);
        numbers.forEach(this::validateRange);
        return numbers;
    }

    public Integer validatePickBonusNumber(String rawInput, List<Integer> sixNumber) throws IllegalArgumentException {
        validateNumber(rawInput);
        Integer number = Integer.parseInt(rawInput);
        validateRange(number);
        validateDuplicateSeven(number, sixNumber);
        return number;
    }

    public Integer validateBuyAmount(String rawInput) throws IllegalArgumentException {
        validateNumber(rawInput);
        Integer amount = Integer.parseInt(rawInput);
        validateModuler(amount);
        return amount;
    }

    public void validateNumberList(String input) {
        if (!input.matches(regexSixNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호를 정확히 입력하세요.");
        }
    }

    public void validateDuplicateSix(List<Integer> input) {
        Set<Integer> set = new HashSet<>();
        for (Integer number : input) {
            if (!set.add(number)) {
                throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 있습니다.");
            }
        }
    }

    public void validateDuplicateSeven(Integer input, List<Integer> sixNumber) {
        if (sixNumber.contains(input)) {
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 존재합니다.");
        }
    }

    public void validateCount(List<Integer> input) {
        if (input.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 번호를 입력하세요.");
        }
    }

    public void validateNumber(String input) {
        if (!input.matches(regexNumber)) {
            throw new IllegalArgumentException("[ERROR] 올바른 금액을 입력하세요.");
        }
    }

    public void validateRange(Integer input) {
        if (input > 45 || input < 1) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void validateModuler(Integer input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 한장은 1000원 입니다. 1000원 단위로 입력하세요.");
        }
    }
}
