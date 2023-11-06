package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoParser {
    private static final String SPLIT_CHAR = ",";
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final String LOTTO_PARSE_ERROR_MESSAGE = "[ERROR] 로또 번호는 숫자만 입력할 수 있습니다.";
    private static final String LOTTO_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 %d부터 %d까지의 수만 입력할 수 있습니다.";

    public static List<Integer> parseWinningInputs(String input) {
        List<Integer> lottoNumbers = new ArrayList<>();
        Arrays.stream(input.split(SPLIT_CHAR)).forEach(digit -> {
            int numberConvert = covertDigitToNumber(digit);
            validateNumberRange(numberConvert);
            lottoNumbers.add(numberConvert);
        });
        return lottoNumbers;
    }

    private static int covertDigitToNumber(String digit) {
        try {
            Integer.parseInt(digit);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LOTTO_PARSE_ERROR_MESSAGE);
        }
        return Integer.parseInt(digit);
    }

    private static void validateNumberRange(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(
                    String.format(LOTTO_RANGE_ERROR_MESSAGE, LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER));
        }
    }
}
