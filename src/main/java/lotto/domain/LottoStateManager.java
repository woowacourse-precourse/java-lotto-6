package lotto.domain;

import lotto.util.InputHelper;

import java.util.List;

public class LottoStateManager {
    private WinningNumbers winningNumbers;
    private int numOfLotto;
    private List<Lotto> generatedLotto;

    private LottoStateManager() {
    }

    private static class Singleton {
        private static final LottoStateManager FLOW_MANAGER = new LottoStateManager();
    }

    public static LottoStateManager getInstance() {
        return Singleton.FLOW_MANAGER;
    }

    public void inputNumOfLotto() {
        this.numOfLotto = InputHelper.numOfLottoToBuy();
    }

    public List<Lotto> generateLotto() {
        List<Lotto> generated = LottoGenerator.generate(this.numOfLotto);
        this.generatedLotto = generated;
        return generated;
    }

    public void inputWinningNumbers() {
        this.winningNumbers = InputHelper.winningNumbers();
    }

    public LottoManager generateLottoManager() {
        return new LottoManager(this.winningNumbers, this.generatedLotto);
    }

    public Result getResult(LottoManager lottoManager) {
        return lottoManager.processLotto();
    }
}
