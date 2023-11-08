package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        alreadyReadValidate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoNumber.NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void alreadyReadValidate(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        if (numbersSet.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isContainNumber(int number) {
        return numbers.contains(number);
    }

    public List<Integer> sortLottoNumbers() {
        List<Integer> sortedLottoNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedLottoNumbers);
        return sortedLottoNumbers;
    }
}
