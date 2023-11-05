package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.exception.NonNumericInputException;
import lotto.vo.BonusNumber;

public class Converter {

    private static final String DELIMITER = ",";

    private Converter() {
    }

    public static List<Integer> convertToLottoNumbers(final String winningNumbers) {
        return Arrays.stream(winningNumbers.split(DELIMITER))
                .map(number -> getLottoNumber(number.trim()))
                .toList();
    }

    public static BonusNumber convertToBonusNumber(final Integer number) {
        return new BonusNumber(number);
    }

    private static Integer getLottoNumber(final String number) {
        try {
            return Integer.valueOf(number);
        } catch (NumberFormatException e) {
            throw new NonNumericInputException();
        }
    }
}
