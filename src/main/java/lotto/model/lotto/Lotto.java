package lotto.model.lotto;

import static lotto.exception.ExceptionMessage.LOTTO_NUMBER_COUNT_ERROR;
import static lotto.exception.ExceptionMessage.LOTTO_NUMBER_OUT_OF_RANGE;
import static lotto.exception.ExceptionMessage.WINNING_NUMBER_DUPLICATION;
import static lotto.utils.constant.IOConstant.LOTTO_POSTFIX;
import static lotto.utils.constant.IOConstant.LOTTO_PREFIX;
import static lotto.utils.constant.IOConstant.OUTPUT_DELIMITER;
import static lotto.utils.constant.LottoConstant.LOTTO_NUMBER_MAX;
import static lotto.utils.constant.LottoConstant.LOTTO_NUMBER_MIN;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_ERROR.getMessage());
        }

        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(WINNING_NUMBER_DUPLICATION.getMessage());
        }

        numbers.forEach(this::checkNumberInRange);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean isNumberExist(int number) {
        return numbers.contains(number);
    }

    public String printLottoInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(LOTTO_PREFIX.getValue());
        for (int number : numbers) {
            sb.append(number)
                    .append(OUTPUT_DELIMITER.getValue());
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(LOTTO_POSTFIX.getValue());
        return sb.toString();
    }

    private void checkNumberInRange(int number) {
        if (number < LOTTO_NUMBER_MIN.getValue() || number > LOTTO_NUMBER_MAX.getValue()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }
}

