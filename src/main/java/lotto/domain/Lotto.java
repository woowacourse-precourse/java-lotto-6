package lotto.domain;

import java.util.Collections;
import java.util.List;

import static lotto.Validator.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberLength(numbers);
        validateNumbers(numbers);
        validateComposedOfUniqueNumbers(numbers);
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

}
