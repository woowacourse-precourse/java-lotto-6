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
            throw new IllegalArgumentException("[ERROR] 숫자를 6개 입력해주세요.");
        }
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) <= 0 | numbers.get(i) >= 45) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
    // TODO: 추가 기능 구현
}
