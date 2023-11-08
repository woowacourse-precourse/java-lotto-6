package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;

public interface LottoService {
    Lottos buyLottos(String payment);
    Lotto drawWinningNumbers(String numbers);
    int drawBonusNumber(String number);
    WinningResult calculateWinning(Lottos lottos, WinningLotto winningLotto);
}
