package lotto.service;

import lotto.domain.LottoStatistics;
import lotto.domain.PlayerLottoNumbers;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningLotto;
import lotto.dto.PlayerLottosFormatter;
import lotto.dto.LottoStatisticsResultFormatter;

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
        lottoStatistics.calculateLottoMatch(playerLottoNumbers, winningLotto);
    }

    public void calculateTotalRate() {
        lottoStatistics.calculateTotalRate(playerLottoNumbers);
    }

    public LottoStatisticsResultFormatter getStatistics() {
        return new LottoStatisticsResultFormatter(lottoStatistics.getStatistics(), lottoStatistics.getTotalRate());
    }
}
