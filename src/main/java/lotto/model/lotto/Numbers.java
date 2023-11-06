package lotto.model.lotto;

import static lotto.exception.ExceptionMessage.LOTTO_NUMBER_COUNT_ERROR;
import static lotto.utils.constant.LottoConstant.LOTTO_NUMBER_COUNT;

import java.util.List;

public record Numbers(
        List<Integer> numbers
) {
    public static Numbers of(List<Integer> numbers) {
        checkNumberSize(numbers);
        return new Numbers(numbers);
    }

    private static void checkNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_ERROR.getMessage());
        }
    }
}
