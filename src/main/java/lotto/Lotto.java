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
            System.out.println("[ERROR] 로또 번호는 6자리로 이뤄져야 합니다.");
            throw new IllegalArgumentException();
        }
        if(new HashSet<>(numbers).size() != numbers.size()){
            System.out.println("[ERROR] 로또 번호는 중복된 숫자가 존재해선 안됩니다.");
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
