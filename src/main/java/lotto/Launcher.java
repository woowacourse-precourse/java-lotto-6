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
        //로또 구매
        PurchaseController purchaseController = createPurchaseController();
        LottoPurchase lottoPurchase = processPurchase(purchaseController);

        //로또 발급
        LottoTickets lottoTickets = issueTickets(lottoPurchase);

        //로또 결과 생성 및 화면 표시
        RankResult rankResult = determineResults(lottoTickets);
        displayResults(rankResult);
        displayProfit(lottoPurchase, rankResult);
    }

    private static PurchaseController createPurchaseController() {
        return new PurchaseController();
    }

    private static LottoPurchase processPurchase(PurchaseController purchaseController) {
        return purchaseController.processPurchase();
    }

    private static LottoTickets issueTickets(LottoPurchase lottoPurchase) {
        IssueController issueController = IssueController.from(lottoPurchase);
        return issueController.issueTickets();
    }

    private static RankResult determineResults(LottoTickets lottoTickets) {
        WinningController winningController = WinningController.from(lottoTickets);
        return winningController.determineResults();
    }

    private static void displayResults(RankResult rankResult) {
        ResultController resultController = ResultController.from(rankResult);
        resultController.showResults();
    }

    private static void displayProfit(LottoPurchase lottoPurchase, RankResult rankResult) {
        ProfitController profitController = ProfitController.of(lottoPurchase, rankResult);
        profitController.showProfit();
    }
}
