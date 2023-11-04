package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sortNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> temp = new HashSet<>(numbers);
        if (temp.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 중복되지 않은 숫자를 입력해주세요.");
        }
    }

    // TODO: 추가 기능 구현
    private void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    @Override
    public String toString() {
        return "[" + String.join(",", numbers
            .stream().map(Object::toString).toArray(String[]::new)) + "]";
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
