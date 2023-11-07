package lotto.model.single;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.Exception.isValidDuplicateNumberException;
import static lotto.Exception.isValidSixNumberException;
import static lotto.util.Constant.ModelClass.LOTTO_NUMBERS_LENGTH;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkIsSixNumber(numbers);
        checkDuplicateNumber(numbers);
    }


    private void checkIsSixNumber(List<Integer> numbers) {
        try{
            isValidSixNumberException(numbers.size());
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void checkDuplicateNumber(List<Integer> numbers) {
        try {
            Set<Integer> numSet = new HashSet<>(numbers);
            isValidDuplicateNumberException(numbers.size() == numSet.size());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean againInputList(){
        Set<Integer> numSet = new HashSet<>(numbers);
        return numbers.size() != numSet.size() || numbers.size() != LOTTO_NUMBERS_LENGTH;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
