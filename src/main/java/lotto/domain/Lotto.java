package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.validator.Errors;
import lotto.view.Output;

public class Lotto {

    public final static int LOTTO_NUMBER_START = 1;
    public final static int LOTTO_NUMBER_END = 45;
    public final static int LOTTO_NUMBER_COUNT = 6;
    public static final int PRICE = 1000;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            Output.printErrorMessage(Errors.NEED_MORE_INPUT.getMessage());
            throw new IllegalArgumentException();
        }
    }


    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            Output.printErrorMessage(Errors.DUPLICATE_NUMBER.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public int getNumberOfMatches(List<Integer> winningNumbers) {
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (winningNumbers.contains(numbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    public boolean containsBonusNumber(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
