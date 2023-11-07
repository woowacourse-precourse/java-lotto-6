package lotto.domain;

import lotto.io.OutputAdaptor;

import java.util.List;

public class Executor {

    public static void execute() {
        Procedure procedure = Procedure.getInstance();
        procedure.inputNumOfLotto();
        List<Lotto> lottos = procedure.generateLotto();
        OutputAdaptor.displayLottoNumbers(lottos);
        procedure.inputWinningNumbers();
        LottoManager lottoManager = procedure.generateLottoManager();
        Result result = procedure.getResult(lottoManager);
        OutputAdaptor.displayResult(result);
        OutputAdaptor.displayRateOfProfit(result.calculateRateOfReturn(lottoManager.getPurchasePrice()));
    }
}
