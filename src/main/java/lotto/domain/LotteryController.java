package lotto.domain;

import lotto.domain.answer.LotteryAnswerController;
import lotto.domain.io.InputView;
import lotto.domain.purchase.LotteryPurchaseController;

public final class LotteryController {
    private static final LotteryPurchaseController lotteryPurchaseController = new LotteryPurchaseController();
    private static final LotteryAnswerController answerController = new LotteryAnswerController();

    public void runGame() {
        // 티켓 개수 구하기
        InputView.getCash();
        Lottos lottos = lotteryPurchaseController.purchase();

        // 개수만큼 구매하기 -> lottos

        // 당첨 번호, 보너스 번호 저장

        // 당첨 통계
    }
}
