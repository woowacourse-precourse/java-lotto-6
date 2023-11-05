package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 로또 번호를 입력해야 합니다.");
        }

        for (int number : numbers) {
            if (1 > number || 45 < number)
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 6개의 로또 번호는 중복되면 안됩니다.");
        }
    }

    private List<Integer> orderNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    public List<Integer> getNumbers() {
        return orderNumbers(this.numbers);
    }


    // TODO: 추가 기능 구현
}
