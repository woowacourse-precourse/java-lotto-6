package lotto.domain.lotto;

import static lotto.util.ExceptionEnum.INVALID_LOTTO_NUMBERS_SIZE;

import java.util.List;

public class Lotto{

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers){
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers){
        throwIfInvalidNumbersSize(numbers);
    }

    private void throwIfInvalidNumbersSize(List<Integer> numbers){
        if (numbers.size() != 6){
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS_SIZE.message());
        }
    }

    public int countWinningNumbers(List<Integer> winningNumbers){
        return -1;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

}
