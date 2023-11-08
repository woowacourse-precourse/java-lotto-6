package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    private void validate(List<Integer> numbers){
        isListLengthSix(numbers);
        isDuplicated(numbers);
        isNumbersInRange(numbers);
    }

    private void isListLengthSix(List<Integer> numbers){
        if (numbers.size() != 6) {
           throw new IllegalArgumentException();
        }
    }

    private void isDuplicated(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if(uniqueNumbers.size() != 6){
            throw new IllegalArgumentException();
        }
    }

    private void isNumbersInRange(List<Integer> numbers){
        for (int number : numbers){
            if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX){
                throw new IllegalArgumentException();
            }
        }
    }
}
