package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.Constant;
import lotto.errormessage.LottoError;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateRangeNumber(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoError.LOTTO_SIZE_ERROR_MESSAGE);
        }
    }

    private void validateRangeNumber(List<Integer> numbers){
        for(int number:numbers){
            if(number< Constant.LOTTO_START_NUMBER || number>Constant.LOTTO_END_NUMBER){
                throw new IllegalArgumentException(LottoError.LOTTO_RANGE_ERROR_MESSAGE);
            }
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers){
        Set<Integer> set = new HashSet<>();
        for(int number:numbers){
            if(set.contains(number)) throw new IllegalArgumentException(LottoError.LOTTO_DUPLICATE_ERROR_MESSAGE);
            set.add(number);
        }
    }
}
