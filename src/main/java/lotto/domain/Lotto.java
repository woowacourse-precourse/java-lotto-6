package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int PRICE = 1000;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> sort(List<Integer> unSortNumbers) {
        List<Integer> lottoNumbers = new ArrayList<>(unSortNumbers);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
