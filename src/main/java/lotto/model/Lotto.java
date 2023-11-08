package lotto.model;

import static lotto.constant.ErrorMessage.ERROR_MESSAGE;
import static lotto.constant.ErrorMessage.LOTTODUPLICATEDNUMBER;
import static lotto.constant.ErrorMessage.LOTTONUMBERRANGEOVER;
import static lotto.constant.ErrorMessage.LOTTONUMBERSIZEEXCEED;
import static lotto.constant.Numbers.LOTTONUMBEREND;
import static lotto.constant.Numbers.LOTTONUMBERSTART;
import static lotto.constant.Numbers.NUMBERSPERLOTTO;

import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers); //sort 여기서
        numbers.sort(Comparator.naturalOrder());
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateDuplicatedNumbers(numbers);
        validateListSize(numbers);
        validateRangeOverValue(numbers);
    }

    // TODO: 추가 기능 구현
    public List<Integer> getLotto() {
        return numbers;
    }

    private void validateDuplicatedNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR_MESSAGE.getValue() + LOTTODUPLICATEDNUMBER.getValue());
        }
    }

    private void validateListSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERSPERLOTTO.getIntValue()) {
            throw new IllegalArgumentException(ERROR_MESSAGE.getValue() + LOTTONUMBERSIZEEXCEED.getValue());
        }
    }

    private void validateRangeOverValue(List<Integer> numbers) {
        for (Integer lottoValue : numbers) {
            if (lottoValue > LOTTONUMBEREND.getIntValue() || lottoValue < LOTTONUMBERSTART.getIntValue()) {
                throw new IllegalArgumentException(ERROR_MESSAGE.getValue() + LOTTONUMBERRANGEOVER.getValue());
            }
        }
    }
}
