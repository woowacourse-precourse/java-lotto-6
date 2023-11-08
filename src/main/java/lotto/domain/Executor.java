package lotto.domain;

import lotto.io.OutputAdaptor;

import java.util.List;

/**
 * 프로그램 전체 흐름을 담당한다.
 */
public class Executor {

    /**
     * 프로그램을 실행한다.
     */
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
