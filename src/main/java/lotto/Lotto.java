package lotto;

import static Constant.ErrorMessage.ERROR_MSG_NUMBER_OF_LOTTO_IS_6;

import Validator.LottoValidator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MSG_NUMBER_OF_LOTTO_IS_6);
        }
        LottoValidator.checkDupilcatedNumber(numbers);
    }

    public Integer getNumber(Integer index) {
        return numbers.get(index);
    }

    public Integer getSize(){
        return numbers.size();
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

}
