package lotto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputValidator {

    public static void validateDivision1000(int number) {
        if (number % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다.");
        }
    }

    public static void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> set = numbers.stream().collect(Collectors.toSet());

        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 번호가 중복되었습니다.");
        }
    }
}
