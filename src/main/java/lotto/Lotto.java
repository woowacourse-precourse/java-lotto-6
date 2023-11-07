package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateUnique(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateUnique(List<Integer> numbers) {
        for (int number : numbers){
            if (Collections.frequency(numbers, number) != 1){
                throw new IllegalArgumentException();
            }
        }
    }

    public int countMatch(List<Integer> winningNumber){
        int result = 0;
        for (int number : numbers){
            if (winningNumber.contains(number)){
                result += 1;
            }
        }
        return result;
    }

    public boolean containBonusNUmber(int bonusNumber){
        return numbers.contains(bonusNumber);
    }


    // TODO: 추가 기능 구현
}
