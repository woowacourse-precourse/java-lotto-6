package lotto.model;

import lotto.exception.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public boolean validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> check = new HashSet<>();
        for (int number : numbers) {
            if (check.contains(number)) throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
            check.add(number);
        }
        return true;
    }
    public int matchNumber(List<Integer> winningNumber) {
        int matchNumber=0;
        for (int i = 0; i < numbers.size(); i++) {
            if(winningNumber.contains(numbers.get(i))){
                matchNumber++;
            }
        }
        return matchNumber;
    }
    public boolean matchBonusNumber(int bonusNumber) {
        if(numbers.contains(bonusNumber)) return true;
        return false;
    }
    @Override
    public String toString() {
        return numbers+"\n";
    }
}
