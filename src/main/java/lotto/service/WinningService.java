package lotto.service;

import java.util.List;
import lotto.domain.LottoCollector;

public interface WinningService {

    void createWinningLotto(List<Integer> winningNumber);

    void createBonusNumber(int bonusNumber);

    String calculateWinningDetail(LottoCollector lottoCollector);
}
