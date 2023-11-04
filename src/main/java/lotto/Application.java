package lotto;

import java.util.List;
import lotto.controller.LottoIssueController;
import lotto.controller.LottoContentController;
import lotto.domain.Lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoIssueController issueController = new LottoIssueController();
        LottoContentController resultController = new LottoContentController();
        // 1. 로또를 발급 받아야 한다.
        // 1.1 로또 금액을 입력 받는다.
        // 입력 금액에 맞는 로또를 발급받아야 한다.
        List<Lotto> lottos = issueController.issueLottos();
        // 2. 발급 결과를 출력해준다.
        resultController.showLottosResult(lottos);
        // 3. 당첨 번호를 보너스 번호와 함께 획득한다.


        // 4. 모든 티켓과 당첨번호를 비교하여
    }
}
