package lotto;

import lotto.controller.IssueController;
import lotto.controller.ProfitController;
import lotto.controller.PurchaseController;
import lotto.controller.ResultController;
import lotto.controller.WinningController;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoTickets;
import lotto.domain.RankResult;

public class Launcher {
    public static void run() {
        // 금액 입력
        PurchaseController purchaseController = new PurchaseController();
        LottoPurchase lottoPurchase = purchaseController.processPurchase();

        // 로또 발급
        IssueController issueController = IssueController.from(lottoPurchase);
        LottoTickets lottoTickets = issueController.issueTickets();

        // 당첨 번호, 보너스 번호 입력 처리
        WinningController winningController = WinningController.from(lottoTickets);
        RankResult rankResult = winningController.determineResults();

        //당첨 결과 출력
        ResultController resultController = ResultController.from(rankResult);
        resultController.showResults();

        ProfitController profitController = ProfitController.of(lottoPurchase, rankResult);
        profitController.showProfit();
    }
}
