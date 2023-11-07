package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoSeller;
import lotto.domain.Lottos;
import lotto.domain.Prize;
import lotto.domain.WinningDetails;
import lotto.domain.WinningLotto;

public class LottoService {
    private final LottoSeller lottoSeller;
    private final WinningDetails winningDetails;
    private WinningLotto winningLotto;

    public LottoService(LottoSeller lottoSeller, WinningDetails winningDetails) {
        this.lottoSeller = lottoSeller;
        this.winningDetails = winningDetails;
    }

    public Lottos buyLotto(int money) {
        int numberOfLottos = lottoSeller.calculateNumberOfLottos(money);
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
        return lottoSeller.calculateProfitRate(money, totalPrize);
    }
}
