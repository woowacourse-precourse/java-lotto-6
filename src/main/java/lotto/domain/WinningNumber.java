package lotto.domain;

import java.util.Arrays;
import java.util.List;
import lotto.util.ErrorMessage;

public class WinningNumber {
    private static final String SEPARATOR = ",";
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningNumber(String lottoNumbers, String bonus) {
        validateLotto(lottoNumbers);
    }

    private static void validateLotto(String numbers) {
        try {
            List<Integer> numberList = Arrays.stream(numbers.split(SEPARATOR))
                    .map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            ErrorMessage.printNotNumericNumberErrorMessage();
            throw new IllegalArgumentException();
        }
    }
}
