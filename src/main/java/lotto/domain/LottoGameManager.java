package lotto.domain;

import java.util.List;

public class LottoGameManager {
    private LottoManager lottoManager;
    private List<Lotto> lottos;

    public LottoGameManager() {
        this.lottoManager = new LottoManager();
    }

    public void start() {
        lottos = lottoManager.buyLotto();
        lottoManager.inputWinningNumbersAndBonusNumber();
        lottoManager.getWinningStatus(lottos);
    }
}
