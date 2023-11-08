package lotto.service;

import lotto.domain.LottoCount;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;

public interface LottoGameService {
    LottoCount computeLottoCount(String purchaseAmount);

    Lottos generateLottos(LottoCount lottoCount);

    WinningNumbers parseWinningNumbers(String winningNumbersInput);
}
