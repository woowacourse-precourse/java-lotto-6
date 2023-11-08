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

    public String getLottoString(){
        String LottoStr = numbers.toString().replaceAll("[^0-9\\[\\] ]","");
        LottoStr = LottoStr.replace(" ", ", ");
        return LottoStr;
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
