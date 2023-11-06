package lotto.validator;

import java.util.List;
import lotto.exception.lotto.LottoSizeException;

public class LottoValidator {
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 45;

    private final int LOTTO_SIZE = 6;

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoSizeException();
        }
    }


}
