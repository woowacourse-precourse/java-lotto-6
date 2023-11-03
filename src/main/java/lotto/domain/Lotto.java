package lotto.domain;

import static lotto.domain.util.LottoParser.validateLottoNumbersList;

import java.util.*;
import lotto.exception.LottoException;

public class Lotto {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> inputNumbers) {
        validateLottoNumbersList(inputNumbers);
        this.numbers = inputNumbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
