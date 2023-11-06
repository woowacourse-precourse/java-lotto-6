package validate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Validator {

    public static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개가 최대 입니다.");
        }
        if (hasDuplicate(numbers)) {
            throw new IllegalStateException("[ERROR] 로또 번호의 숫자는 중복될 수 없습니다..");
        }

    }

    public static void isInvalidPriceUnit(int userInputPrice) {
        if (userInputPrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    private static boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        return set.size() != numbers.size();
    }
}
