package lotto.Exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbersException {

    public static void validateLottoNumbers(List<Integer> numbers) {
        notSixNumbers(numbers);
        duplicateNumber(numbers);
        for (Integer number : numbers) {
            numberNotInRange(number);
        }
    }

    public static void notSixNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 가지고 있지 않습니다.");
        }
    }

    public static void duplicateNumber(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);

        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복 숫자가 존재합니다.");
        }
    }

    public static void numberNotInRange(Integer number) {
        if (!(1 <= number && number <= 45)) {
            throw new IllegalArgumentException("[ERROR] 1~45의 범위가 아닌 숫자가 있습니다.");
        }
    }

}
