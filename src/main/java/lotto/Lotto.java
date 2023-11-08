package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    // TODO: 추가 기능 구현

    private void validateDuplicate(List<Integer> numbers){
        Set<Integer> duplicate = new HashSet<Integer>(numbers);
        if(duplicate.size() != numbers.size()){
            throw new IllegalArgumentException();
        }
    }


    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return ""+numbers+"";
    }
}
