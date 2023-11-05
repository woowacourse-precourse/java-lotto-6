package lotto.domain;

import java.util.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> temp = new HashSet<>(numbers);
        if (temp.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 중복되지 않은 숫자를 입력해주세요.");
        }
    }

    // TODO: 추가 기능 구현
    @Override
    public String toString() {
        return "[" + String.join(", ", numbers
            .stream().map(Object::toString).toArray(String[]::new)) + "]";
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
