package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import lotto.validator.NumberValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> choiceNumbers) {
        NumberValidator.validateNumberSize(choiceNumbers);
        NumberValidator.validateDuplicate(choiceNumbers);
        this.numbers = new ArrayList<Integer>(choiceNumbers); 
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
