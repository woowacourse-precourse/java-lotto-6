package lotto;

import lotto.Enum.LottoError;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int LOTTO_NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LottoError.NumberCount.getErrorMessage());
        }
        if(!validateDuplicatedNumber(numbers)){
            throw new IllegalArgumentException(LottoError.NumberDuplication.getErrorMessage());
        }
        if(!validateOverRangeNumber(numbers)){
            throw new IllegalArgumentException(LottoError.NumberRange.getErrorMessage());
        }
    }

    private boolean validateDuplicatedNumber(List<Integer> numbers){
        Set<Integer> numberSet = new HashSet<>(numbers);
        return numbers.size() == numberSet.size();
    }

    private boolean validateOverRangeNumber(List<Integer> numbers){
        for(int number : numbers){
            if(number > MAX_LOTTO_NUMBER || number < MIN_LOTTO_NUMBER){
                return false;
            }
        }
        return true;
    }

}
