package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;

public interface LottoService {
    Lottos buyLottos(String payment);
}
