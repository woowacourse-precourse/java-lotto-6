package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException{
        validate(new HashSet<>(numbers));
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    private void validate(Set<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자를 중복 없이 혹은 6자리를 넘지 않았는지 확인하세요.");
        }
    }

    // TODO: 추가 기능 구현
}
