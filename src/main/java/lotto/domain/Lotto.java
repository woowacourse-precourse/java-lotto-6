package lotto.domain;

import java.util.HashSet;
import java.util.List;
import lotto.CommonLotto;
import lotto.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumberRedundant(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != CommonLotto.LOTTO_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberRedundant(List<Integer> numbers){
        boolean isRedundant = numbers.size() > new HashSet<>(numbers).size();
        if(isRedundant){
            ErrorMessage.redundantExcept();
            throw new IllegalArgumentException();
        }
    }

    public int countMatch(List<Integer> winningNum) {
        return (int) numbers.stream()
                .filter(winningNum::contains)
                .count();
    }

    public Boolean bonusMatch(int bonusNum) {
        return numbers.stream()
                .anyMatch(num -> num == bonusNum);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
