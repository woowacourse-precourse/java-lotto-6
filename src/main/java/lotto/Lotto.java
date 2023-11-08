package lotto;

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
            throw new IllegalArgumentException();
        }
    }

    public boolean containsAll(Lotto lotto) {
        return this.numbers.containsAll(lotto.numbers);
    }

    public boolean contain(int number){
        return this.numbers.contains(number);
    }

    public int returnNumber(int index){
        return this.numbers.get(index);
    }

    // TODO: 추가 기능 구현
}
