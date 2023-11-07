package lotto;

import static Constant.ErrorMessage.ERROR_MSG_DUPLICATED_LOTTO_NUMBER;
import static Constant.ErrorMessage.ERROR_MSG_NUMBER_OF_LOTTO_IS_6;

import java.util.ArrayList;
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
        checkDupilcatedNumber(numbers);
    }

    public  void checkDupilcatedNumber(List<Integer> value) throws IllegalArgumentException{
        List<Integer> testValue = new ArrayList<>(value);
        for (Integer oneValue : value) {
            testValue.remove(oneValue);
            if (testValue.contains(oneValue)) {
                throw new IllegalArgumentException(ERROR_MSG_DUPLICATED_LOTTO_NUMBER);
            }
        }
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
