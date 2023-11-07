package lotto.service;

import lotto.domain.*;
import lotto.formatter.PlayerLottosFormatter;
import lotto.formatter.LottoStatisticsResultFormatter;

public class LottoService {

    private final PlayerLottoNumbers playerLottoNumbers;
    private final LottoStatistics lottoStatistics;
    private WinningLotto winningLotto;


    public LottoService(PlayerLottoNumbers playerLottoNumbers, LottoStatistics lottoStatistics) {
        this.playerLottoNumbers = playerLottoNumbers;
        this.lottoStatistics = lottoStatistics;
    }

    public void saveLottos(PurchasePrice purchasePrice) {
        playerLottoNumbers.saveLottos(purchasePrice);
    }

    public PlayerLottosFormatter getPlayerLottoNumbers() {
        return new PlayerLottosFormatter(playerLottoNumbers.getLottoValues());
    }

    public void saveWinningLotto(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void calculateWinningStatistics() {
        for (Numbers numbers : playerLottoNumbers.getLottoValues()) {
            Integer matchCount = numbers.getMatchCount(winningLotto.getLotto()).intValue();
            Boolean isMatchBonusNumber = numbers.isMatchBonusNumber(winningLotto.getBonusNumber());
            lottoStatistics.upWinningFactorValue(matchCount, isMatchBonusNumber);
        }
    }

    public void calculateTotalRate() {
        lottoStatistics.calculateTotalRate(playerLottoNumbers);
    }

    public LottoStatisticsResultFormatter getStatistics() {
        return new LottoStatisticsResultFormatter(lottoStatistics.getStatistics(), lottoStatistics.getTotalRate());
    }
}
