package lotto.domain;

import lotto.domain.answer.LotteryAnswerController;
import lotto.domain.answer.number.LottoAnswer;
import lotto.domain.purchase.LotteryPurchaseController;

public final class LotteryController {
    private static final LotteryPurchaseController purchaseController = new LotteryPurchaseController();
    private static final LotteryAnswerController answerController = new LotteryAnswerController();

    public void runGame() {
        // 티켓 구매
        User user = purchaseController.purchaseLottoTickets();

        // 당첨 번호, 보너스 번호 저장
        LottoAnswer answer = answerController.getAnswer();

        // 당첨 통계
        answerController.getResult(user, answer);
    }
}
