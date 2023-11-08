package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class LottoValidation {
    private static final String NATURE_PATTERN = "^[1-9][0-9]*$";

    public static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>();

        for (Integer number : numbers) {
            numberSet.add(number);
        }

        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 내에 중복값이 있습니다.");
        }
    }

    public static void validateNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumberRange(number);
        }
    }

    public static void validateNumberRange(Integer lottoValue) {
        if (lottoValue < 1 || lottoValue > 45) {
            throw new IllegalArgumentException("[ERROR] 각각의 값은 1 ~ 45의 값이여야 합니다.");
        }
    }

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또는 6개의 숫자로 이루어져야합니다.");
        }
    }

    public static void validateNatureValue(String number) {
        if (!Pattern.matches(NATURE_PATTERN, number)) {
            throw new IllegalArgumentException("[ERROR] 한 요소는 자연수 입니다.");
        }
    }
}
