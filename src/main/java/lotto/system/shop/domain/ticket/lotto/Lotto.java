package lotto.system.shop.domain.ticket.lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.system.shop.exception.lotto.DuplicateLottoNumberException;
import lotto.system.shop.exception.lotto.LottoSizeException;

public class Lotto {

    private static final Integer LOTTO_NUMBERS_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> sortedNumbers = sort(numbers);
        this.numbers = sortedNumbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicated(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new LottoSizeException();
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        List<Integer> target = new ArrayList<>();
        for (Integer number : numbers) {
            if (target.contains(number)) {
                throw new DuplicateLottoNumberException();
            }
            target.add(number);
        }
    }

    private List<Integer> sort(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        sortedNumbers.sort(Comparator.naturalOrder());
        return sortedNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
