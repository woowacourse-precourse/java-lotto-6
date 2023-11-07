package lotto.model;

import java.util.List;

import static lotto.util.MagicNumbers.MIN_NUMBER;
import static lotto.util.MagicNumbers.MAX_NUMBER;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    //여기에 validate 이 있어야할 이유가 있나? 따로 class 하는게 나을 것 같은데
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        for(int number: numbers){
            if(MIN_NUMBER <= number && number <= MAX_NUMBER)
                throw new IllegalArgumentException();

        }
    }
    //여기에 추가해야할 이유가 있나..?




}

