package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberValidator {
    final int lottoNumberCount = 6;
    public boolean hasDuplicateNumbers(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        return uniqueNumbers.size()==lottoNumberCount;
    }
}
