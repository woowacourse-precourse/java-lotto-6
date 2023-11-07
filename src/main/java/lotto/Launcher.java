package lotto;

import lotto.controller.IssueController;
import lotto.controller.PurchaseController;
import lotto.controller.WinningController;
import lotto.domain.Purchase;

public class Launcher {
    public static void run() {
        // 금액 입력 처리
        PurchaseController purchaseController = new PurchaseController();
        Purchase purchase = purchaseController.processPurchase();

        // 로또 발급
        IssueController issueController = IssueController.from(purchase);
        issueController.issueTickets();

        // 당첨 번호, 보너스 번호 입력 처리
        WinningController winningController = new WinningController();
    }
}
