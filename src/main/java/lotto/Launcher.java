package lotto;

import lotto.controller.IssueController;
import lotto.controller.PurchaseController;
import lotto.controller.ResultController;
import lotto.controller.WinningController;
import lotto.domain.LottoTickets;
import lotto.domain.Purchase;
import lotto.domain.RankResult;

public class Launcher {
    public static void run() {
        // 금액 입력
        PurchaseController purchaseController = new PurchaseController();
        Purchase purchase = purchaseController.processPurchase();

        // 로또 발급
        IssueController issueController = IssueController.from(purchase);
        LottoTickets lottoTickets = issueController.issueTickets();

        // 당첨 번호, 보너스 번호 입력 처리
        WinningController winningController = WinningController.from(lottoTickets);
        RankResult rankResult = winningController.determineResults();

        //당첨 결과 출력
        ResultController resultController = new ResultController(rankResult);
        resultController.showResults();
    }
}
