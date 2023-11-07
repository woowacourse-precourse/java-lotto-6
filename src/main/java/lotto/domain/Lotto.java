package lotto.domain;

import static lotto.utils.ErrorMessage.IS_INVALID_LOTTO_SIZE;
import static lotto.utils.ErrorMessage.IS_LOTTO_DUPLICATED;
import static lotto.utils.LottoConstants.LOTTO_SIZE;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> numbersCopy = new ArrayList<>(numbers);
        numbersCopy.forEach(LottoSingleNumber::new);
        numbersCopy.sort(Comparator.naturalOrder());
        validate(numbersCopy);
        this.numbers = numbersCopy;
    }

    private void validate(List<Integer> numbers) {
        isLottoSizeValid(numbers);
        isLottoDuplicated(numbers);
    }

    protected void isLottoSizeValid(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(IS_INVALID_LOTTO_SIZE.getMessage());
        }
    }

    private void isLottoDuplicated(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(IS_LOTTO_DUPLICATED.getMessage());
        }
    }

    public int countMatchingNumbers(Lotto otherLotto) {
        return (int) numbers.stream()
                .filter(otherLotto::containsNumber)
                .count();
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
