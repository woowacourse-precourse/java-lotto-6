package lotto;

import camp.nextstep.edu.missionutils.Randoms;


import java.util.Collections;
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
            throw new IllegalArgumentException("6개의 번호를 입력하지 않았습니다");
        }
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    // TODO: 추가 기능 구현
    private boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            Integer number = numbers.get(i);
            if (!uniqueNumbers.add(number)) {
                return true; // 중복 발견
            }
        }
        return false; // 중복 없음
    }
    public List<Integer> getNumbers() {
        return numbers;
    }


}
