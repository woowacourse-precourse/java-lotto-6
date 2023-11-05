package lotto.utils.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {
    public static void valid(List<Integer> numbers) throws IllegalArgumentException{
        duplicateNumberCheck(numbers);
        countValidCheck(numbers);
    }
    private static void duplicateNumberCheck(List<Integer> numbers) {
        Set<Integer> nubersSet = new HashSet<>(numbers);
        if (nubersSet.size() != numbers.size()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }
    private static void countValidCheck(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 총 6개여야 합니다.");
        }
    }


}
