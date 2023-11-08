package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicateNumbers(numbers);
        validateOutOfRange(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private void validateDuplicateNumbers(List<Integer> numbers) {
        HashSet<Integer> hashNumbers = new HashSet<>(numbers);
        if(hashNumbers.size() != numbers.size()){
            throw new IllegalArgumentException();
        }
    }
    private void validateOutOfRange(List<Integer> numbers){
        for(Integer number : numbers){
            if(!(number >= 1 && number <= 45)){
                throw  new IllegalArgumentException();
            }
        }
    }
    // TODO: 추가 기능 구현
}
