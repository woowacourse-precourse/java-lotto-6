package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberConvertor {

    private static final String DELIMITER = ",";
    private static final String NUMBERS_ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE = "[ERROR] 로또 번호는 숫자로만 구성 되어야 합니다. 다시 입력해주세요";
    private static final String NUMBER_ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE = "[ERROR] 보너스 번호는 한 개의 숫자여야 합니다. 다시 입력해주세요";

    private NumberConvertor() {
    }

    public static List<Integer> convertToNumbers(String lottoNumberInput) {
        try {
            return getNumbers(lottoNumberInput.split(DELIMITER));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBERS_ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
        }
    }

    public static Integer convertToNumber(String bonusNumberInput) {
        try {
            return Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
        }
    }

    private static List<Integer> getNumbers(String[] split) {
        return Arrays.stream(split)
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
