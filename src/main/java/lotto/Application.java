package lotto;

import java.util.List;
import java.util.Map;
import lotto.controller.TotalLottoController;
import lotto.domain.Lotto;
import lotto.domain.LottoConsumer;
import lotto.domain.LottoPrizeStatus;
import lotto.domain.LottoResult;
import lotto.domain.ResultStatics;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        TotalLottoController totalLottoController = new TotalLottoController();

        List<Lotto> issuedLottos = totalLottoController.issueLottos();
        LottoConsumer consumer = new LottoConsumer(issuedLottos);
        totalLottoController.showLottoNumbers(issuedLottos);
        // 3. 당첨 로또를 발급받는다.
        LottoResult lottoResult = totalLottoController.issueLottoResult();
        // 4. 모든 티켓과 당첨번호를 비교하여 통계 결과를 출력한다.
        ResultStatics resultStatics = consumer.calculateResult(lottoResult);
        totalLottoController.showStatistics(resultStatics);
    }
}
