package lotto;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        sortLottoNumbers();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    private void sortLottoNumbers() {
        Collections.sort(this.numbers);
    }

    public void displayLottoNumbers() {
        System.out.println(numbers.toString());
    }


}
