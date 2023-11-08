package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public interface LottoService {
    Lottos buyLottos(String payment);
    Lotto drawWinningNumbers(String numbers);
}
