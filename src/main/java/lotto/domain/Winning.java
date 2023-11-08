package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.util.Convertor;
import lotto.util.Validator;

public class Winning {

    private final List<Integer> numbers;

    public Winning(String inputNumbers) {
        List<Integer> nubmers = Convertor.convertToIntegerList(inputNumbers);
        Validator.validateLottoNumbers(nubmers);
        this.numbers = nubmers;

    }

    public List<Integer> getNumbers() {

        return Collections.unmodifiableList(numbers);
    }
}
