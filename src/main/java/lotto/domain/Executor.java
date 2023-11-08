package lotto.domain;

import lotto.io.OutputAdaptor;

import java.util.List;

public class Executor {

    public static void execute() {
        LottoStateManager lottoStateManager = LottoStateManager.getInstance();
        lottoStateManager.inputNumOfLotto();
        List<Lotto> lottos = lottoStateManager.generateLotto();
        OutputAdaptor.displayLottoNumbers(lottos);
        lottoStateManager.inputWinningNumbers();
        LottoManager lottoManager = lottoStateManager.generateLottoManager();
        Result result = lottoStateManager.getResult(lottoManager);
        OutputAdaptor.displayResult(result);
        OutputAdaptor.displayRateOfProfit(result.calculateRateOfReturn(lottoManager.getPurchasePrice()));
    }
}
