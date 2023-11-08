package lotto.domain;

import java.util.List;
import lotto.utils.LottoUtils;
import lotto.validation.Validation;

public class Lotto {
    protected final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = LottoUtils.sortAsc(numbers);
    }

    private void validate(List<Integer> numbers) {
        Validation.checkLottoNumberLength(LottoInfo.LENGTH.getValue(), numbers);
        Validation.checkLottoNumberRange(LottoInfo.START.getValue(), LottoInfo.END.getValue(), numbers);
        Validation.checkDuplicate(numbers);
    }

    public void showNumbers() {
        System.out.println(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
