package lotto.domain;

import java.util.List;
import lotto.util.Convertor;
import lotto.util.Validator;

public class Winning {
    private final List<Integer> numbers;

    public Winning(String inputNumbers) {
        List<Integer> nubmers = Convertor.getInstance().convertToIntegerList(inputNumbers);
        Validator.getInstance().validateLottoNumbers(nubmers);
        this.numbers = nubmers;

    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
