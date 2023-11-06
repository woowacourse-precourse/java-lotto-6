package lotto.domain;

import lotto.Controller;

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
            Controller.lottoNumbersSixOverException();
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            Controller.lottoNumbersHasDuplicateException();
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < MIN_VALUE || numbers.get(i) > MAX_VALUE) {
                Controller.lottoNumbersMustBeBetweenException();
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
