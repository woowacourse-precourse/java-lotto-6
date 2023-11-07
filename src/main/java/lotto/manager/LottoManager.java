package lotto.manager;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;

import java.util.List;

public class LottoManager {

    private static final int DEFAULT_LOTTO_PRICE = 1000;

    public Lottos createLottos(Payment payment) {

        int affortableLottoCount = payment.countAffortable(DEFAULT_LOTTO_PRICE);

        return Lottos.createByCount(
                affortableLottoCount,
                () -> Randoms.pickUniqueNumbersInRange(
                        Lotto.MIN_LOTTO_NUMBER, Lotto.MAX_LOTTO_NUMBER, Lotto.LOTTO_NUMBER_SIZE
                )
        );
    }

    public WinningLotto createWinningLotto(List<Integer> winningNumbers, int bonusNumber) {

        return new WinningLotto(winningNumbers, bonusNumber);
    }

    public LottoResult calculateResult(Lottos lottos, WinningLotto winningLotto) {
        LottoRankings winRankings = lottos.calculateRankings(winningLotto);
        return winRankings.toLottoResult();
    }
}
