package lotto.entity;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException("로또 번호에 중복된 값이 있습니다.");
        }

        this.numbers = numbers;
    }

    // 중복된 번호를 확인하는 메서드
    private boolean hasDuplicates(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        return set.size() < numbers.size();
    }

    // 다른 메서드 및 멤버 변수 정의
}
