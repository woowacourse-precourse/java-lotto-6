package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoConstant;
import lotto.exception.ModelExceptionConstant;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ModelExceptionConstant.DUPLICATED_NUMBERS.getText());
        }
    }

    public List<Integer> getLotto() {
        return new ArrayList<>(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_NUMBER_COUNT.value()) {
            throw new IllegalArgumentException();
        }
    }

    public int countDuplicatedNumbers(List<Integer> winningNumbers) {
        List<Integer> compareNumbers = new ArrayList<>(numbers);

        compareNumbers.retainAll(winningNumbers);

        return compareNumbers.size();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
