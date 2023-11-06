package lotto;

import lotto.Enum.LottoError;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.Enum.constants.*;

public class Lotto {
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
        if (numbers.size() != LOTTO_NUMBER_COUNT.getNumber()) {
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
            if(number > MAX_LOTTO_NUMBER.getNumber() || number < MIN_LOTTO_NUMBER.getNumber()){
                return false;
            }
        }
        return true;
    }

}
