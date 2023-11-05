package lotto.Service;

import lotto.Lotto;

import java.util.List;

public interface LottoService {
    void initializeLottery(int cost);
    int getNumberOfLotto();
    List<Lotto> getLotto();
    List<Integer> getResultRecordOfLotto(Lotto winningLotteryNumber, int bonusNumber);
}
