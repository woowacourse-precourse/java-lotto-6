package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        int moneyInput = lottoService.moneyInput();
        List<Lotto> lottos = lottoService.lottoIssuance(lottoService.lottoCount(moneyInput));
        lottoService.lottosPrint(lottos);
        int[] winningNumberInput = lottoService.winningNumberInput();
        lottoService.bonusNumberInput();
        lottoService.lottoResult(lottos, winningNumberInput);
        lottoService.lottoResultPrint(moneyInput);


    }
}
