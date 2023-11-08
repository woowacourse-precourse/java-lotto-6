package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class WinningLottoFactory {
    private static final String NUMBER_FORMAT_ERROR = "[ERROR] 정수만 입력하세요.";
    private static final String LOTTO_NUMBER_DELIMITER = ",";

    public static WinningLotto of(String lottoNumbersInput) {
        List<LottoNumber> lottoNumbers = splitNumbers(lottoNumbersInput).stream()
                .map(LottoNumber::new)
                .toList();
        return new WinningLotto(lottoNumbers);
    }

    private static List<Integer> splitNumbers(String lottoNumbers) {
        try {
            return Arrays.stream(lottoNumbers.split(LOTTO_NUMBER_DELIMITER))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR);
        }
    }
}