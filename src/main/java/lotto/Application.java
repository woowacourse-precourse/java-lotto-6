package lotto;

import lotto.controller.*;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PurchaseController purchaseController = new PurchaseController();
        purchaseController.handle();
        
        NumberGenerateController numberGenerateController = new NumberGenerateController();
        numberGenerateController.handle();

        WinningNumberController winningNumberController = new WinningNumberController();
        winningNumberController.handle();

        WinningBonusNumberController winningBonusNumberController = new WinningBonusNumberController();
        winningBonusNumberController.handle();

        WinningStatisticsController winningStatisticsController = new WinningStatisticsController();
        winningStatisticsController.handle();

        ProfitController profitController = new ProfitController();
        profitController.handle();

    }
}
