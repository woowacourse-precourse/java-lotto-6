package lotto.domain;

import lotto.view.InputView;

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
        Set<Integer> set = new HashSet<>();
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호의 갯수는 6개 이하여야한다.");
            throw new IllegalArgumentException();
        }
        isExisted(set, numbers);
    }

    // TODO: 추가 기능 구현

    private void isExisted(Set<Integer> set, List<Integer> list) {
        for (Integer s : list) {
            if (set.contains(s)) {
                System.out.println("[ERROR] 로또 번호는 중복 되면 안됩니다.");
                throw new IllegalArgumentException();
            }
            set.add(s);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
