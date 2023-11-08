package lotto.domain;

import java.util.Collections;
import java.util.List;

import static lotto.ErrorMessage.NOT_COMPOSED_OF_UNIQUE_NUMBERS;
import static lotto.ErrorMessage.NOT_VALID_LENGTH;
import static lotto.Validator.validateNumberInRange;
import static lotto.Validator.validatePositiveNumber;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumbers(numbers);
        validateComposedOfUniqueNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NOT_VALID_LENGTH);
        }
    }

    private void validateNumbers(List<Integer> numbers){
        for(int number : numbers){
            validatePositiveNumber(number);
            validateNumberInRange(number);
        }
    }

    public List<Integer> getLottoNumbers(){
        return Collections.unmodifiableList(numbers);
    }

    protected int compareLottoNumbers(List<Integer> lottoNumbers){
        int count = 0;
        for(Integer number : lottoNumbers){
            if(this.numbers.contains(number)){
                count++;
            }
        }
        return count;
    }

    private void validateComposedOfUniqueNumbers(List<Integer> numbers){
        long unique_number = numbers.stream().distinct().count();
        if(unique_number < numbers.size()){
            throw new IllegalArgumentException(NOT_COMPOSED_OF_UNIQUE_NUMBERS);
        }
    }





}
