package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.enums.WinningRankType;

public interface LottoService {
    Lottos buyLottos(String payment);
    Lotto drawWinningNumbers(String numbers);
    int drawBonusNumber(String number);
    WinningResult calculateWinning(Lottos lottos, WinningLotto winningLotto);
    WinningRankType matchRankType(Lotto lotto, WinningLotto winningLotto);
    double calculateRateOfReturn(WinningResult winningResult, int payment);
}
