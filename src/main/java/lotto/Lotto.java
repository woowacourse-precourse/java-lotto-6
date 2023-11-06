package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        hasDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void hasDuplication(List<Integer> balls) {
        Set<Integer> deDuplicate = new HashSet<>();
        for (int ball : balls) {
            if (deDuplicate.contains(ball)) throw new IllegalArgumentException();
            deDuplicate.add(ball);
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> showBallNumber() {
        return numbers;
    }
}
