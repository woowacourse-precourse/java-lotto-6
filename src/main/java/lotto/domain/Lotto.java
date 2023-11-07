package lotto.domain;

import lotto.view.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int LOTTO_START = 1;
    public static final int LOTTO_END = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateBoundaryNumbers(numbers);
        validateSix(numbers);
        validateOverlapNumber(numbers);
        this.numbers = sortNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateSix(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_SIX_MESSAGE.getValue());
        }
    }
    private void validateBoundaryNumbers(List<Integer> numbers) {
        try {
            for (int i = 0; i < numbers.size(); i++)
                validateBoundaryNumber(numbers.get(i));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void validateBoundaryNumber(int input) {
        if (input < LOTTO_START || input > LOTTO_END)
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_1_TO_45_MESSAGE.getValue());
    }


    private void validateOverlapNumber(List<Integer> numbers) {
        for (Integer i : numbers)
            if (Collections.frequency(numbers, i) > 1)
                throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_OVERLAP_MESSAGE.getValue());
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<Integer>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }
}
