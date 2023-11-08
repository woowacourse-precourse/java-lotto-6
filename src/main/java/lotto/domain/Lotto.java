package lotto.domain;

import java.util.HashSet;
import java.util.List;

import static lotto.util.Util.sortList;

// 로또에 관한 도메인
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortList(numbers);
    }

    private void validate(List<Integer> numbers) {
        HashSet<Integer> num = new HashSet<>(numbers);
        if (num.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    // TODO: 추가 기능 구현
}
