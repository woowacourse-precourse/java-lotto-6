package lotto;

import lotto.controller.LottoController;

public class Application {

    public static void main(String[] args) {
        LottoController.setPrice();
        LottoController.setBuyLottoNumberPrint();
        LottoController.setPrizeNumberInput();
        LottoController.winningStatistic();
        LottoController.PerformanceCalculation();

    }


}
