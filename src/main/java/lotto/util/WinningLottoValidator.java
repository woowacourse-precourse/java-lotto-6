package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.config.LottoConfig;
import lotto.exception.InvalidLottoNumberFormatException;
import lotto.exception.InvalidLottoSplitterCountException;

public class WinningLottoValidator {

    public static void validate(String winningLottoNumbers) {
        validateSplitterCount(winningLottoNumbers);
        List<String> splitWinningLotto = getSplitWinningLotto(winningLottoNumbers);
        splitWinningLotto.forEach(WinningLottoValidator::validateLottoNumberFormat);
    }

    private static void validateSplitterCount(String winningLotto) {
        int winningLottoSplitterCount = calculateSplitterCount(winningLotto);
        if (winningLottoSplitterCount != LottoConfig.LOTTO_NUMBER_COUNT - 1) {
            throw new InvalidLottoSplitterCountException(winningLottoSplitterCount);
        }
    }

    private static int calculateSplitterCount(String winningLotto) {
        return winningLotto.length() - winningLotto.replaceAll(LottoConfig.WINNING_LOTTO_SPLITTER, "").length();
    }

    private static List<String> getSplitWinningLotto(String winningLotto) {
        return Arrays.stream(winningLotto.split(LottoConfig.WINNING_LOTTO_SPLITTER))
                .collect(Collectors.toList());
    }

    private static void validateLottoNumberFormat(String lottoNumber) {
        try {
            Integer.parseInt(lottoNumber);
        } catch (NumberFormatException exception) {
            throw new InvalidLottoNumberFormatException(lottoNumber);
        }
    }
}
