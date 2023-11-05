package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 총 6개여야 합니다.");
        }
        Set<Integer> nubersSet = new HashSet<>(numbers);
        if (nubersSet.size() != numbers.size()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }
    public boolean numberCheck(int number) {
        return numbers.contains(number);
    }
    public String getStringNumbers() {
        return numbers.toString();
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
}
