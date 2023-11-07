package lotto;

import java.util.List;

public class lottoBonus extends Lotto{

    public lottoBonus(List<Integer> numbers) {
        super(numbers);
    }

    private void validate(List<Integer> numbers){
        if (numbers.size() != 1){
            throw new IllegalArgumentException();
        }
    }
}
