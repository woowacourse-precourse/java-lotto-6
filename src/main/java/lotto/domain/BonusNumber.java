package lotto.domain;

import static lotto.exception.ErrorMessage.IS_NOT_ONE_NUMBER;
import static lotto.exception.ErrorMessage.IS_NOT_SIX_NUMBERS;
import static lotto.validator.InputValidator.validateEmpty;
import static lotto.validator.InputValidator.validateNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.LottoException;
import lotto.validator.InputValidator;

public class BonusNumber {

    public static List<Integer> addBonusNumber(List<Integer> winningNumbers, String input){
        validateEmpty(input);
        validateNumber(input);

        int bonusNumber = Integer.parseInt(input);
        winningNumbers.add(bonusNumber);
        System.out.println(winningNumbers);

        return winningNumbers;
    }

    private static void validateLength(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 7) {
            throw LottoException.of(IS_NOT_ONE_NUMBER);
        }
    }
}
