package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final Integer MAX_LOTTO_NUMBER = 45;
    private final Integer MIN_LOTTO_NUMBER = 1;
    private final List<Integer> numbers;
    private final Integer bonusNumber;

    public Lotto(List<Integer> numbers, Integer bonusNumber) {
        validate(numbers);
        this.numbers = numbers;

        validBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        if (hasDuplicates(numbers)){
            throw new IllegalArgumentException();
        }

        if (isNumbersOutOfRange(numbers)){
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicates(List<Integer> numbers){
        Set<Integer> numbersSet = new HashSet<>(numbers);
        return numbersSet.size() != numbers.size();
    }

    private boolean isNumbersOutOfRange(List<Integer> numbers){
        return numbers.stream().anyMatch(number -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER);
    }

    private void validBonusNumber(Integer bonusNumber){
       if (bonusNumber == null){
           throw new IllegalArgumentException();
       }

        if (hasDuplicates(bonusNumber)){
            throw new IllegalArgumentException();
        }

        if (isNumbersOutOfRange(bonusNumber)){
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicates(Integer bonusNumber){
        Set<Integer> numbersSet = new HashSet<>(this.numbers);
        numbersSet.add(bonusNumber);
        return numbersSet.size() != this.numbers.size() + 1;
    }

    private boolean isNumbersOutOfRange(Integer bonusNumber){
        return bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER;
    }
}
