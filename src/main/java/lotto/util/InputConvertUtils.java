package lotto.util;

import java.util.Arrays;
import java.util.List;

import static lotto.constants.Constants.Strings.LOTTO_NUMBERS_INPUT_DELIMITER;
import static lotto.constants.ErrorMessage.HAVE_TO_INPUT_ONLY_NUMBER_AND_DELIMITER;

public class InputConvertUtils {
    public static List<Integer> lottoNumbersToIntegerList(String lottoNumbers) throws NumberFormatException {
        try {
            return Arrays.stream(lottoNumbers.split(LOTTO_NUMBERS_INPUT_DELIMITER.getValue()))
                .map(Integer::parseInt)
                .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(HAVE_TO_INPUT_ONLY_NUMBER_AND_DELIMITER.getMessage());
        }
    }
}
