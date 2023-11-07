package lotto.domain;

import java.util.Arrays;
import java.util.List;
import lotto.util.ErrorMessage;
import lotto.util.Validator;

public class WinningNumber {
    private static final String SEPARATOR = ",";
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningNumber(String lottoNumbers, int bonus) {
        validateLotto(lottoNumbers);
        List<Integer> numbers = stringToIntList(lottoNumbers);
        validateBonusNumber(numbers, bonus);
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

    private static void validateBonusNumber(List<Integer> lotto, int bonus) {
        Validator.validateInputRange(bonus);
        Validator.validateBonusNumberInLotto(lotto, bonus);
    }

    private static List<Integer> stringToIntList(String numbers) {
        return Arrays.stream(numbers.split(SEPARATOR))
                .map(Integer::parseInt).toList();
    }
}
