package lotto.domain;

import lotto.exception.LottoGameException;

import java.util.*;

import static lotto.validator.LottoValidator.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws LottoGameException {
        validateLottoLength(numbers);
        validateDuplicateNumber(numbers);

        this.numbers = numbers;
    }

    @Override
    public String toString() {
        ArrayList<Integer> numbers = new ArrayList<>(this.numbers);
        Collections.sort(numbers);
        return numbers.toString();
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}
