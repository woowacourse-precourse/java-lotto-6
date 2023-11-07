package lotto.domain;

import lotto.io.OutputAdaptor;
import lotto.util.InputHelper;

import java.util.List;

public class Procedure {
    private WinningNumbers winningNumbers;
    private int numOfLotto;
    private List<Lotto> generatedLotto;

    private Procedure() {
    }

    private static class SingletonProcedure {
        private static final Procedure PROCEDURE = new Procedure();
    }

    public static Procedure getInstance() {
        return SingletonProcedure.PROCEDURE;
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
