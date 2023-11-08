package lotto;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validate_(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void validate_(List<Integer> numbers) {
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있습니다.");
        }
    }



    private boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    // TODO: 추가 기능 구현
}
