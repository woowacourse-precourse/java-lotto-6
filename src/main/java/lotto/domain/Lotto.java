package lotto.domain;

import lotto.ui.Output;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int PRICE = 1000;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;
    public static final int NUMBER_OF_MEMBERS = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_OF_MEMBERS) {
            throw new IllegalArgumentException(Output.MUST_BE_SIX_NUMBER_ERROR);
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(Output.HAS_DUPLICATE_NUMBER_ERROR);
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < MIN_VALUE || numbers.get(i) > MAX_VALUE) {
                throw new IllegalArgumentException(Output.MUST_BE_BONUS_NUMBER_BETWEEN_1_45_ERROR);
            }
        }
    }

    private List<Integer> sort(List<Integer> unSortNumbers) {
        List<Integer> lottoNumbers = new ArrayList<>(unSortNumbers);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
