package lotto.Validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ConfigurationNumbers;
import lotto.constant.ExceptionMessage;

public class LottoValidator {
    public static void isUnvalidLength(List<Integer> numbers) {
        if (numbers.size() != ConfigurationNumbers.LOTTO_LENGTH.getNumber()) {
            throw new IllegalArgumentException(ExceptionMessage.UNVALID_LENGTH.getMessage());
        }
    }

    public static void isDuplicated(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numbers.size() != numberSet.size()) {
            throw new IllegalArgumentException(ExceptionMessage.IS_DUPLICATED.getMessage());
        }
    }
}
