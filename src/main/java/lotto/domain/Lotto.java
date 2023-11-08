package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.validator.LottoValidator;

/*
 *   로또의 관련된 정보를 담당
 * */

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        ArrayList<Integer> initialNumbers = new ArrayList<>(numbers);
        Collections.sort(initialNumbers);
        this.numbers = Collections.unmodifiableList(new ArrayList<>(initialNumbers));
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.numbersSizeDifferent(numbers);
        LottoValidator.numbersOverValueRange(numbers);
        LottoValidator.numbersDuplicated(numbers);
    }

    // TODO: 추가 기능 구현

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int findSameCount(Lotto lotto) {
        long count = numbers.stream()
                .filter(lotto.numbers::contains)
                .count();
        return (int) count;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
