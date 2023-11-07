package lotto.validate;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class LottoValidate {

    public static void lottoNumbersRuleValidate(List<Integer> givenNumberStrings) {
        lottoNumbersSizeValidate(givenNumberStrings);
        lottoNumbersDuplicateValidate(givenNumberStrings);
        lottoNumbersRangeValidate(givenNumberStrings);
    }

    public static void lottoNumbersSizeValidate(List<Integer> givenNumbers) {
        if (givenNumbers.size() != 6) {
            throw new IllegalArgumentException("6 자가 아님");
        }
    }

    public static void lottoNumbersDuplicateValidate(List<Integer> givenNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(givenNumbers);
        if (uniqueNumbers.size() != givenNumbers.size()) {
            throw new IllegalArgumentException("중복 된 숫자임.");
        }
    }

    public static void lottoNumbersRangeValidate(List<Integer> givenNumbers) {
        for (Integer number : givenNumbers) {
            if (1 > number || number > 46) {
                throw new IllegalArgumentException("입력 범위 밖.");
            }
        }
    }
}
