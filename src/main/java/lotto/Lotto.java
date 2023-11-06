package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
            throw new IllegalArgumentException("[Error] 로또번호는 6개만 가능합니다. ");
        }
    }

    private void validateDuplicate(List<Integer> numbers){
        Set<Integer> noDuplicateNumbers = new HashSet<>(numbers);
        if(noDuplicateNumbers.size() != 6){
            throw  new IllegalArgumentException("[Error] 로또 번호들은 중복 될수가 없습니다.");
        }
    }
}
