package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateUnique(numbers);
        validateSorted(numbers);
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

    private void validateSorted(List<Integer> numbers){
        for (int i = 0; i < numbers.size() - 1; i++)
        {
            if (numbers.get(i) > numbers.get(i+1)) {
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
}
