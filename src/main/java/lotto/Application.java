package lotto;

import java.util.List;
import lotto.controller.TotalLottoController;
import lotto.domain.Lotto;
import lotto.domain.LottoConsumer;
import lotto.domain.WinningLotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        TotalLottoController totalLottoController = new TotalLottoController();

        List<Lotto> issuedLottos = totalLottoController.issueLottos();
        LottoConsumer consumer = new LottoConsumer(issuedLottos);

        totalLottoController.showLottoNumbers(issuedLottos);
        // 3. 당첨 번호를 보너스 번호와 함께 획득한다.
        Lotto winningLotto = totalLottoController.issueWinningLotto();
        WinningLotto lottoResult = totalLottoController.issueLottoResult(winningLotto);
        // 4. 모든 티켓과 당첨번호를 비교하여
    }
}
