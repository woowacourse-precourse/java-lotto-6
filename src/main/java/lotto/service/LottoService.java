package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;
import lotto.domain.Lottos;
import lotto.domain.Prize;
import lotto.domain.WinningDetails;
import lotto.domain.WinningLotto;

public class LottoService {
    private final LottoManager lottoManager;
    private final WinningDetails winningDetails;
    private WinningLotto winningLotto;

    public LottoService(LottoManager lottoManager, WinningDetails winningDetails) {
        this.lottoManager = lottoManager;
        this.winningDetails = winningDetails;
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
        winningDetails.increasePrizeAmount(prize);
    }

    public WinningDetails statisticsLottoResult(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            rankLotto(lotto);
        }

        return winningDetails;
    }

    public double getProfitRate(int money) {
        int totalPrize = winningDetails.calculateTotalPrize();
        return lottoManager.calculateProfitRate(money, totalPrize);
    }
}
