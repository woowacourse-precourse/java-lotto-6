package lotto.domain;

import java.util.List;
import lotto.utils.LottoUtils;
import lotto.validation.Validation;

public class Lotto {
    protected static final int START = 1;
    protected static final int END = 45;
    protected static final int LENGTH = 6;
    protected final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = LottoUtils.sortAsc(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        Validation.checkLottoNumberLength(LENGTH, numbers);
        Validation.checkLottoNumberRange(START, END, numbers);
        Validation.checkDuplicate(numbers);
    }

    public void showNumbers() {
        System.out.println(numbers);
    }
}
