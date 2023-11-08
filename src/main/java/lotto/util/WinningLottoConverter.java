package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.config.LottoConfig;
import lotto.domain.WinningLotto;

public class WinningLottoConverter {

    public static WinningLotto convertToWinningLotto(String winningLottoInput) {
        List<Integer> lottoNumbers = convertToLottoNumbers(winningLottoInput);
        return WinningLotto.from(lottoNumbers);
    }

    private static List<Integer> convertToLottoNumbers(String winningLottoInput) {
        return Arrays.stream(winningLottoInput.split(LottoConfig.WINNING_LOTTO_SPLITTER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
