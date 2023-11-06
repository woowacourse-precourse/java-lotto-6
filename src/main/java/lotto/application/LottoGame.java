package lotto.application;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {
    public void play() {
        Money money = Money.from(InputView.inputMoney());   // 구매금액 입력
        int ticket = TicketMachine.getTicket(money);    // 티켓 발행
        ResultView.printTicket(ticket);     // "n개를 구매했습니다."
        Lottos lottos = Lottos.from(ticket);    // 티켓 갯수만큼 로또 발행
        ResultView.showLottoNumbers(lottos);    // 발행한 로또 리스트 보여줌
        WinNumber winNumber = InputView.inputWinNumbers();   // 당첨 번호, 보너스 번호 입력
        PrizeResult prizeResult = PrizeResult.from(lottos, winNumber);  // 비교 결과 생성
        ResultView.showResult(prizeResult);   // 비교 결과 출력
        ResultView.showReturnRate(prizeResult, money);// 수익률 계산 후 출력
    }
}
