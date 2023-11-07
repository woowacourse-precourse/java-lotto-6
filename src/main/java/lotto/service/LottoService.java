package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;
import lotto.domain.Lottos;
import lotto.domain.Prize;
import lotto.domain.Prizes;
import lotto.domain.WinningLotto;

public class LottoService {
    private final LottoManager lottoManager;
    private final Prizes prizes;
    private WinningLotto winningLotto;

    public LottoService(LottoManager lottoManager, Prizes prizes) {
        this.lottoManager = lottoManager;
        this.prizes = prizes;
    }

    public Lottos buyLotto(int money) {
        int numberOfLottos = lottoManager.calculateNumberOfLottos(money);
        return Lottos.createLottos(numberOfLottos);
    }

    public void drawWinningLotto(List<Integer> numbers, int bonusNumber) {
        winningLotto = WinningLotto.of(numbers, bonusNumber);
    }

    public void rankLotto(Lotto lotto) {
        int matchedCount = winningLotto.countMatchingNumbers(lotto);
        boolean isMatchedBonusNumber = winningLotto.isMatchBonusNumber(lotto);
        Prize prize = Prize.determineRank(matchedCount, isMatchedBonusNumber);
        prizes.increasePrizeAmount(prize);
    }

    public Prizes statisticsLottoResult(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            rankLotto(lotto);
        }

        return prizes;
    }

    public double getProfitRate(int money) {
        int totalPrize = prizes.calculateTotalPrize();
        return lottoManager.calculateProfitRate(money, totalPrize);
    }
}
