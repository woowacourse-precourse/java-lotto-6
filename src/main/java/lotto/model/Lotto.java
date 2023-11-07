package lotto.model;

import lotto.Util.WinningLottoNumberUtil;
import lotto.constant.ExceptionConstants;
import lotto.constant.GameConstants;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNoDuplicates(numbers);
        checkNumberInRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionConstants.ERROR_NUMBER_COUNT);
        }
    }
    public static void validateNoDuplicates(List<Integer> numbers){
        int distinctCount = numbers.stream().distinct().collect(Collectors.toList()).size();
        if(distinctCount < GameConstants.LOTTO_SIZE){
            throw new IllegalArgumentException(ExceptionConstants.ERROR_DUPLICATE_NUMBER);
        }
    }
    public static void checkNumberInRange(List<Integer> numbers){
        for(int number: numbers){
            if(number < GameConstants.STARTINCLUSIVE){
                throw new IllegalArgumentException(String.format(ExceptionConstants.ERROR_NUMBER_OUT_OF_MIN_RANGE,GameConstants.STARTINCLUSIVE));
            }
            if(number > GameConstants.ENDINCLUSIVE){
                throw new IllegalArgumentException(String.format(ExceptionConstants.ERROR_NUMBER_OUT_OF_MAX_RANGE,GameConstants.ENDINCLUSIVE));

            }
        }
    }

    public List<Integer> getLotto(){
        return numbers;
    }

}
