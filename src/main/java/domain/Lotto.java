package lotto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        replicated(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int hashCode() {
        return numbers.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        Lotto other = (Lotto) obj;
        return other.numbers == this.numbers;
    }

    private void replicated(List<Integer> numbers){
        Set<Integer> set = numbers.stream()
                .collect(Collectors.toSet());
        if(set.size() != 6){
            throw new IllegalArgumentException();
        }
    }


}
