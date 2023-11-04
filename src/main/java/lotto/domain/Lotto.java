package lotto.domain;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateNumberDuplicate(numbers);
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberDuplicate(List<Integer> numbers){
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if(distinctNumbers.size() != numbers.size()){
            throw new IllegalArgumentException();
        }
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    @Override
    public String toString(){
        return numbers.toString();
    }

    public int compare(Lotto lotto){
        return (int) numbers.stream().map(lotto::contains).count();
    }
}
