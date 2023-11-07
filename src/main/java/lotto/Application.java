package lotto;

import lotto.controller.TotalLottoController;
import lotto.domain.Lottos;
import lotto.domain.LottoResult;
import lotto.domain.ResultStatics;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        TotalLottoController totalLottoController = new TotalLottoController();

        Lottos lottos = totalLottoController.issueLottos();
        totalLottoController.showLottoNumbers(lottos);

        LottoResult lottoResult = totalLottoController.issueLottoResult();

        ResultStatics resultStatics = lottos.calculateResult(lottoResult);
        totalLottoController.showStatistics(resultStatics);
    }
}
