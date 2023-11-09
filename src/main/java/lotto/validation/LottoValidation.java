package lotto.validation;

import java.util.List;

import static constant.LottoValue.*;
import static exception.ExceptionMessage.*;

public class LottoValidation {

    public void lottoValidate(List<Integer> numbers){
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if(numbers.size() != LOTTO_SIZE.value()){
            throw new IllegalArgumentException(LOTTO_NUMBERS_SIZE.message());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int i = 0; i < LOTTO_SIZE.value(); i++) {
            Integer num = numbers.get(i);
            if (num < LOTTO_MINIMUM_NUMBER.value() || num > LOTTO_MAXIMUM_NUMBER.value()){
                throw new IllegalArgumentException(LOTTO_NUMBERS_RANGE.message());
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATE.message());
        }
    }
}
