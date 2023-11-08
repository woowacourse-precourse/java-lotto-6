package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.Validator.LottoValidator;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.validateLottoNumbers(numbers);
    }

    public List<Integer> getSortedNumbers() {
        List<Integer> ret = new ArrayList<Integer>(numbers);
        ret.sort(null);
        return ret;
    }

    public void printNumbersInAscendingOrder() {
        OutputService.printLottoNumbers(this.getSortedNumbers());
    }
}
