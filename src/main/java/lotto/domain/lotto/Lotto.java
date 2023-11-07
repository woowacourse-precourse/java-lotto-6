package lotto.domain.lotto;

import java.util.List;

public class Lotto{

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers){
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers){
        if (numbers.size() != 6){
            throw new IllegalArgumentException();
        }
    }

    public int countWinningNumbers(List<Integer> winningNumbers){
        return -1;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

}
