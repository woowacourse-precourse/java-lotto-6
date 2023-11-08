package lotto.domain;

import java.util.List;
import lotto.util.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
        checkValidRange(numbers);

        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers(){
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicate(List<Integer> numbers){
        Validator.isIntListDuplicate(numbers);
    }

    private void checkValidRange(List<Integer> numbers) {
        numbers.forEach((num)->{
            Validator.isValidRange(num);
        });
    }
}
