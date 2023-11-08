package lotto.domain;

import java.util.List;

public class LottoGameManager {
    private LottoManager lottoManager;
    private List<Lotto> lottos;

    public LottoGameManager() {
        this.lottoManager = new LottoManager();
    }

    public void start() {
        buyLottos();
        getInputWinningNumbersAndBonusNumber();
        getWinningStatus();
    }

    private void getWinningStatus() {
        lottoManager.getWinningStatus(lottos);
    }

    private void getInputWinningNumbersAndBonusNumber() {
        lottoManager.inputWinningNumbersAndBonusNumber();
    }

    private void buyLottos() {
        lottos = lottoManager.buyLotto();
    }
}
