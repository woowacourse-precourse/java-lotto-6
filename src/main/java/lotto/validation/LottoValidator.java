package lotto.validation;

import lotto.domain.Lotto;
import lotto.view.OutputView;

import java.util.List;

public class LottoValidator {
    private static final Integer LOTTO_SIZE=6;

    public static void DuplicatedNum(List<Integer> numbers) {
        long count = numbers.stream()
                .distinct()
                .count();

        if (count != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public static void ticketSizeValidate(List<Lotto> numbers, Integer size) {
        if (numbers.size() != size) {
            OutputView.errorMessage(LottoErrorMessage.INCORRECT_LOTTO.getMessage());
            throw new IllegalArgumentException();
        }
    }
}
