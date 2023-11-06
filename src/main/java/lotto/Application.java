package lotto;

import lotto.controller.TotalLottoController;
import lotto.domain.LottoConsumer;
import lotto.domain.LottoResult;
import lotto.domain.ResultStatics;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        TotalLottoController totalLottoController = new TotalLottoController();
        LottoConsumer lottoConsumer = totalLottoController.issueLottos();
        totalLottoController.showLottoNumbers(lottoConsumer);
        // 3. 당첨 로또를 발급받는다.
        LottoResult lottoResult = totalLottoController.issueLottoResult();
        // 4. 모든 티켓과 당첨번호를 비교하여 통계 결과를 출력한다.
        ResultStatics resultStatics = lottoConsumer.calculateResult(lottoResult);
        totalLottoController.showStatistics(resultStatics);
    }
}
