package lotto.domain.lotto;

import static lotto.util.ExceptionEnum.INVALID_NUMBERS_SIZE;
import static lotto.util.ExceptionEnum.INVALID_NUMBER_RANGE;
import static lotto.util.ExceptionEnum.NUMBER_OUT_OF_RANGE;

import java.util.List;

public class Lotto{

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers){
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers){
        throwIfInvalidNumbersSize(numbers);
        throwIfNumbersOutOfRange(numbers);
    }

    private void throwIfInvalidNumbersSize(List<Integer> numbers){
        if (numbers.size() != 6){
            throw new IllegalArgumentException(INVALID_NUMBERS_SIZE.message());
        }
    }

    private void throwIfNumbersOutOfRange(List<Integer> numbers){
        for (Integer number : numbers){
            if (!isInRange(number)){
                throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.message());
            }
        }
    }

    private boolean isInRange(int number){
        return number >= 1 && number <= 45;
    }

    public int countWinningNumbers(List<Integer> winningNumbers){
        return -1;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

}
