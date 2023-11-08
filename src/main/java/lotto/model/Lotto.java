package lotto.model;

import lotto.constant.message.ErrorMessage;

import java.util.HashSet;
import java.util.List;

import static lotto.constant.SystemData.MAX_IN_LOTTO_NUMBER;
import static lotto.constant.SystemData.MIN_IN_LOTTO_NUMBER;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers){
        validateNumberLength(numbers);
        validateDuplicate(numbers);
        validateNumberRange(numbers);
    }

    private void validateNumberLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int number : numbers){
            if(hashSet.contains(number)){
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBER);
            }
            hashSet.add(number);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for(int number : numbers){
            if(number < MIN_IN_LOTTO_NUMBER || number > MAX_IN_LOTTO_NUMBER){
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBER);
            }
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
