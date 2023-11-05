package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberValidator {
    final static int lottoNumberCount = 6;
    public static boolean hasDuplicateNumbers(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        return uniqueNumbers.size()==lottoNumberCount;
    }
}
