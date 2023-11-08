package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean hasNumber(int number){
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException{
        validateNumberBoundary(numbers);
        validateSize(numbers);
        validateDuplication(numbers);
    }

    private void validateNumberBoundary (List<Integer> numbers) throws IllegalArgumentException {
        if(numbers.stream().anyMatch(n->n<1||n>45)){
            throw new IllegalArgumentException("[ERROR]로또 숫자의 범위는 1부터 45 사이야합니다.");
        }
    }

    private void validateSize(List<Integer> numbers) throws IllegalArgumentException{
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또의 숫자는 6개여야 합니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers) throws IllegalArgumentException{
        int setSize = Set.copyOf(numbers).size();
        if(setSize != 6)
        {
            throw new IllegalArgumentException("[ERROR] 번호가 중첩되어서는 안됩니다.");
        }
    }
}
