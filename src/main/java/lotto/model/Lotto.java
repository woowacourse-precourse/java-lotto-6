package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        validateOverlap(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private void validateRange(List<Integer> numbers){
        for (int winningNumber = 0; winningNumber<numbers.size();winningNumber++){
            if(!(numbers.get(winningNumber) >= 1 && numbers.get(winningNumber) <= 45)){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateOverlap(List<Integer> numbers){
        Set<Integer> overlapCheck = new HashSet<>();
        for (int i = 0;i< numbers.size();i++){
            overlapCheck.add(numbers.get(i));
        }

        if (overlapCheck.size() != 6){
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public int countMatch(Lotto winningLotto){
        return (int) numbers.stream().
                filter(winningLotto::containNumber).
                count();
    }
    public boolean containNumber(int number){
        return numbers.contains(number);
    }
}
