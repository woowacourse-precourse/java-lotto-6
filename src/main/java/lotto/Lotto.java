package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리로 이뤄져야 합니다.");
        }
        if(new HashSet<>(numbers).size() != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 숫자가 존재해선 안됩니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
