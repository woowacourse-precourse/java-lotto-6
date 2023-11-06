package lotto.domain;

import lotto.domain.answer.LotteryAnswerController;
import lotto.domain.answer.number.LottoAnswer;
import lotto.domain.io.InputView;
import lotto.domain.io.OutputView;
import lotto.domain.purchase.LotteryPurchaseController;

public final class LotteryController {
    private static final LotteryPurchaseController purchaseController = new LotteryPurchaseController();
    private static final LotteryAnswerController answerController = new LotteryAnswerController();

    public void runGame() {
        // 금액 입력
        InputView.getCash();
        Integer ticketCount = purchaseController.getLottoTicketCount();
        OutputView.printLottoAmount(ticketCount);
        // 티켓 구매
        Lottos lottos = purchaseController.purchase(ticketCount);
        String lottosStatus = lottos.toString();
        OutputView.printLottos(lottosStatus);

        // 당첨 번호, 보너스 번호 저장
        InputView.getLottoAnswer();
        Lotto answer = answerController.getLottoAnswer();
        Integer bonus = answerController.getBonusAnswer();
        LottoAnswer lottoAnswer = new LottoAnswer(answer, bonus);

        // 당첨 통계
    }
}
