package lotto;

import java.util.List;
import lotto.controller.TotalLottoController;
import lotto.domain.Lotto;
import lotto.domain.LottoConsumer;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        TotalLottoController totalLottoController = new TotalLottoController();
        // 1. 로또를 발급 받아야 한다.
        // 1.1 로또 금액을 입력 받는다.
        // 입력 금액에 맞는 로또를 발급받아야 한다.
        List<Lotto> issuedLottos = totalLottoController.issueLottos();
        LottoConsumer consumer = new LottoConsumer(issuedLottos);
        // 2. 발급 결과를 출력해준다.
        totalLottoController.showLottoNumbers(issuedLottos);
        // 3. 당첨 번호를 보너스 번호와 함께 획득한다.

        // 4. 모든 티켓과 당첨번호를 비교하여
    }
}
