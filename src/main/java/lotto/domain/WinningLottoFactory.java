package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class WinningLottoFactory {
    private static final String INTEGER_ERROR_MESSAGE = "[ERROR] 정수만 입력해야 합니다.";
    private static final String LOTTO_NUMBER_SEPERATOR = ",";

    public static WinningLotto of(String lottoNumbersInput) {
        return new WinningLotto(splitNumbers(lottoNumbersInput));
    }

    private static List<Integer> splitNumbers(String lottoNumbers) {
        try {
            return Arrays.stream(lottoNumbers.split(LOTTO_NUMBER_SEPERATOR))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INTEGER_ERROR_MESSAGE);
        }
    }
}
