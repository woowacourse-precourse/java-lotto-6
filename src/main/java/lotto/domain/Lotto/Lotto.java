package lotto.domain.Lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void checkDuplicate(List<Integer> numbers) {
        Set<Integer> numberWithoutDuplicate = new HashSet<>(numbers);
        if (numbers.size() != numberWithoutDuplicate.size()) {
            System.out.println("[ERROR] 로또의 숫자는 중복될 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }

}
