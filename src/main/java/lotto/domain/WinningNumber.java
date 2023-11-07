package lotto.domain;

import java.util.Arrays;
import java.util.List;
import lotto.util.ErrorMessage;

public class WinningNumber {
    private static final String SEPARATOR = ",";
    private final Lotto lotto;

    public WinningNumber(String numbers) {
        validateLotto(numbers);
        List<Integer> lottoNumbers = stringToIntList(numbers);

        this.lotto = new Lotto(lottoNumbers);
    }

    public Lotto getLotto() {
        return lotto;
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

    private List<Integer> stringToIntList(String numbers) {
        return Arrays.stream(numbers.split(SEPARATOR))
                .map(Integer::parseInt).toList();
    }
}