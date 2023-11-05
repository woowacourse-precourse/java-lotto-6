package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberValidator extends Validator{
    private final static int LOTTO_NUMBER_COUNT = 6;
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;
    public static boolean hasDuplicateNumbers(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        return uniqueNumbers.size()==LOTTO_NUMBER_COUNT;
    }

    public static boolean validateLottoNumbersRange(List<Integer> numbers){
        for (Integer number : numbers){
            if(!validateNumberRange(number, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)){
                return false;
            }
        }
        return true;
    }
}
