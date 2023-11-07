package lotto.model; //패키지 변경은 가능

import java.util.List;

import static lotto.util.NumbersValidator.checkDuplicate;
import static lotto.util.NumbersValidator.checkElementsInRange;
import static lotto.util.NumbersValidator.validate;

public class Lotto {

    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
        checkElementsInRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

}
